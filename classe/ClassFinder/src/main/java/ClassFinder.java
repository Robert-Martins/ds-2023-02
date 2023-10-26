import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;

public class ClassFinder {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: fc <nome da classe> <dir> [-p]");
            return;
        }

        String className = args[0];
        String directory = args[1];
        boolean useParallelStream = args.length > 2 && args[2].equals("-p");

        long startTime = System.nanoTime();
        List<String> foundLocations = new ArrayList<>();

        try {
            searchForClass(className, new File(directory), useParallelStream, foundLocations);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long elapsedTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        if (foundLocations.isEmpty()) {
            System.out.println("Classe não encontrada.");
        } else {
            System.out.println("Classe encontrada em:");
            for (String location : foundLocations) {
                System.out.println(location);
            }
        }

        System.out.println("Tempo gasto: " + elapsedTime + " ms");
        System.out.println("Número de arquivos .class consultados: " + foundLocations.size());
    }

    private static void searchForClass(String className, File directory, boolean useParallelStream, List<String> foundLocations) throws IOException {
        File[] files = directory.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                searchForClass(className, file, useParallelStream, foundLocations);
            } else {
                if (file.getName().endsWith(".class")) {
                    String filePath = file.getCanonicalPath();
                    if (useParallelStream) {
                        List<String> classLocations = getClassLocationsParallel(filePath, className);
                        foundLocations.addAll(classLocations);
                    } else {
                        List<String> classLocations = getClassLocations(filePath, className);
                        foundLocations.addAll(classLocations);
                    }
                } else if (file.getName().endsWith(".jar") || file.getName().endsWith(".war")) {
                    String filePath = file.getCanonicalPath();
                    List<String> classLocations = getClassLocationsFromJarOrWar(filePath, className);
                    foundLocations.addAll(classLocations);
                }
            }
        }
    }

    private static List<String> getClassLocations(String filePath, String className) throws IOException {
        List<String> classLocations = new ArrayList<>();
        String content = new String(java.nio.file.Files.readAllBytes(new File(filePath).toPath()));
        if (content.contains(className)) {
            classLocations.add(filePath);
        }
        return classLocations;
    }

    private static List<String> getClassLocationsParallel(String filePath, String className) throws IOException {
        return getClassLocations(filePath, className);
    }

    private static List<String> getClassLocationsFromJarOrWar(String filePath, String className) throws IOException {
        List<String> classLocations = new ArrayList<>();
        try (JarFile jarFile = new JarFile(filePath)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                    String entryName = entry.getName().replace("/", ".").replace(".class", "");
                    if (entryName.equals(className)) {
                        classLocations.add(filePath);
                    }
                }
            }
        }
        return classLocations;
    }
}
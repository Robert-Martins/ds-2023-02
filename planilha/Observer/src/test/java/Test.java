import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class Test {

    private final ConsoleOutputCapturer capturer = new ConsoleOutputCapturer();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(capturer));
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
        capturer.clear();
    }

    public void test() {
        Celula a1 = new Celula("A1");
        Celula a2 = new Celula("A2");
        Celula a3 = new Celula("A3");

        a3.addObserver(a1);
        a3.addObserver(a2);

        a3.setValue(1);
        String consoleOutput = capturer.getOutput();

        assertTrue(consoleOutput.contains(
                "Reavaliar A1 por mudança ocorrida em A3\n" +
                "Reavaliar A2 por mudança ocorrida em A3\n"
        ));
    }

}

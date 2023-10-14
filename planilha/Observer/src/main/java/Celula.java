import java.util.ArrayList;
import java.util.List;

public class Celula {

    private String celula;
    private Integer value;
    private List<Celula> observers;

    public Celula(String celula) {
        this.celula = celula;
        this.observers = new ArrayList<>();
    }

    public void setValue(Integer value) {
        if (this.value != value) {
            this.value = value;
            notifyObservers();
        }
    }

    public void addObserver(Celula observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        this.observers.forEach(this::printNotification);
    }

    public String getCelula() {
        return celula;
    }

    public Integer getValue() {
        return value;
    }

    private void printNotification(Celula observer) {
        System.out.println(observer.notification(observer));
    }

    private String notification(Celula observer) {
        return "Reavaliar " + observer.getCelula() + " por mudança ocorrida em " + this.celula + "\n";
    }

}

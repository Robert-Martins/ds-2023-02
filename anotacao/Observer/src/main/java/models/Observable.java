package models;

public class Observable<Y> {

    private Y y;

    private final static Integer EMPTY_ARRAY = 0;

    public Observable(Y y) {
        this.y = y;
    }

    public Boolean isObservable(String observed) {
        return this.y.getClass().getSimpleName().equalsIgnoreCase(observed);
    }

    public String getObservableObject() {
        return this.y.toString();
    }

}

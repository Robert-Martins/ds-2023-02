package models;

import actions.EmptyAction;
import annotations.Observe;

import java.util.ArrayList;
import java.util.List;

public class Observer<T, Y> {

    private T t;

    private List<Observable<Y>> observables = new ArrayList<>();

    public Observer(T t) {
        this.t = t;
    }

    public void add(Observable<Y> observable, EmptyAction action) {
        if(this.hasAnnotation() && observable.isObservable(this.getObservable()))
            this.observables.add(observable);
        else
            action.run();
    }

    public void notifyObservables() {
        this.observables.stream().map(Observable::getObservableObject).forEach(System.out::println);
    }

    private Boolean hasAnnotation() {
        return this.t.getClass().isAnnotationPresent(Observe.class);
    }

    private String getObservable() {
        return this.t.getClass().getAnnotation(Observe.class).observado();
    }

}

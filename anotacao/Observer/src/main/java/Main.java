import models.*;

public class Main {

    public static void main(String[] args) {
        Chefe chefe = new Chefe("MD");
        Funcionario funcionario1 = new Funcionario("Robert");
        Funcionario funcionario2 = new Funcionario("Gabriel");
        Observer<Chefe, Funcionario> observer = new Observer<>(chefe);
        observer.add(new Observable<>(funcionario1), () -> System.out.println("Funcionário 1 não foi incluso"));
        observer.add(new Observable<>(funcionario2), () -> System.out.println("Funcionário 2 não foi incluso"));
        observer.notifyObservables();
    }

}

import java.util.ArrayList;
import java.util.List;

public class Showroom {
    final int maxCarsInShowroom = 3;
    final int TIME_FOR_SELL = 1000;
    final int TIME_FOR_ACCEPT = 2000;
    List<Car> car = new ArrayList<>(maxCarsInShowroom);

    List<Car> getCar() {
        return car;
    }

    public synchronized void sellCar() {
        System.out.println(Thread.currentThread().getName() + " зашёл в автосалон.");
        try {
            while (car.size() == 0) {
                System.out.println("Автосалон не может продавать, авто закончились.");
                wait();
            }
            Thread.sleep(TIME_FOR_SELL);
            car.remove(0);
            System.out.println("Авто куплено. " + Thread.currentThread().getName() + " едет домой.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void acceptCar() {
        try {
            Thread.sleep(TIME_FOR_ACCEPT);
            System.out.println("Автомобиль прибыл в салон.");
            car.add(new Car("BMW"));
            notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

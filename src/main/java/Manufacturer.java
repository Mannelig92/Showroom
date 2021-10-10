public class Manufacturer implements Runnable {
    private final Showroom showroom;
    private final int maxCars = 5;
    private final int TIME_FOR_CREATE = 1000;

    public Manufacturer(Showroom showroom) {
        this.showroom = showroom;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < maxCars; i++) {
            System.out.println("Завод готовится к выпуску новых машин.");
            try {
                Thread.sleep(TIME_FOR_CREATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            showroom.acceptCar();
        }
    }
}

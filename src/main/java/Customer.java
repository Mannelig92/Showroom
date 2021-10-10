public class Customer implements Runnable {
    Showroom showroom;

    public Customer(Showroom showroom) {
        this.showroom = showroom;
    }

    @Override
    public void run() {
        showroom.sellCar();
    }
}

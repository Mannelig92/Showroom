public class Main {

    public static void main(String[] args) {
        final Showroom showroom = new Showroom();
        final Manufacturer manufacturer = new Manufacturer(showroom);
        final Customer customer = new Customer(showroom);
        new Thread(null, customer, "Покупатель Александр").start();
        new Thread(null, customer, "Покупатель Игорь").start();
        new Thread(null, customer, "Покупатель Сергей").start();
        new Thread(null, customer, "Покупатель Анастасия").start();
        new Thread(null, customer, "Покупатель Михаил").start();

        new Thread(null, manufacturer, "Продавец").start();
    }
}

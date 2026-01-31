package Factory;

public class Truck implements Transport {
    @Override
    public void startTransport(Long value) {
        System.out.println("Start transport by Truck with value: " + value);
    }
}


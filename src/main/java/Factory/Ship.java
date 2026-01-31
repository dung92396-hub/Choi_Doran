package Factory;

public class Ship implements Transport {
    @Override
    public void startTransport(Long value) {
        System.out.println("Start transport by Ship with value: " + value);
    }
}

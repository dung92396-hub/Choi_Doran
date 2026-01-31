package Factory;

public class Container implements Transport {
    @Override
    public void startTransport(Long value) {
        System.out.println("Start transport by Container with value: " + value);
    }
}

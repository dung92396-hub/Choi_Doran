package Factory;

public class Main {
    public static void main(String[] args) {
        TransportFactory transportFactory = new TransportFactory();
        Transport t = transportFactory.getTransport(TransportType.CONTAINER);
        t.startTransport(10L);
    }
}

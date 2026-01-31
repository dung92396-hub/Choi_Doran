package Factory;

public class TransportFactory {
    public Transport getTransport(TransportType type) {
        return switch (type) {
            case type.TRUCK -> new Truck();
            case type.CONTAINER -> new Container();
            case type.SHIP -> new Ship();
        };
    }
}

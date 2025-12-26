package MetroCredit;

import java.util.List;

public class Credit {
    private Long creditID;
    private Type type;
    private Location startPoint;
    private Location endPoint;
    private final double PRICE = 7000;


    public Credit(Long creditID, Type type, Location startPoint, Location endPoint) {
        this.creditID = creditID;
        this.type = type;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Long getCreditID() {
        return creditID;
    }

    public void setCreditID(Long creditID) {
        this.creditID = creditID;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double cost() {
        return Math.abs(Tram.lengthOfTrams(startPoint, endPoint) * this.PRICE);
    }

    public Location getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Location startPoint) {
        this.startPoint = startPoint;
    }

    public Location getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Location endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return String.format("┌─────────────────────┬────────────────────────────────┐\n" +
                             "│ %-19s │ %-30s │\n" +
                             "├─────────────────────┼────────────────────────────────┤\n" +
                             "│ %-19s │ %-30d │\n" +
                             "│ %-19s │ %-30s │\n" +
                             "│ %-19s │ %-30s │\n" +
                             "│ %-19s │ %-30s │\n" +
                             "│ %-19s │ %-30.2f │\n" +
                             "└─────────────────────┴────────────────────────────────┘",
                "Credit Information", "",
                "Credit ID", this.creditID,
                "Type", this.type,
                "Start Point", this.startPoint,
                "End Point", this.endPoint,
                "Cost", this.cost());
    }
}

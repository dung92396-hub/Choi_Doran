package MetroCredit;

import java.util.ArrayList;
import java.util.List;

public class CreditsManager {
    private final List<Credit> credits = new ArrayList<>();

    public void addCredit(Long creditID, Type type, Location startPoint, Location endPoint) {
        if (containsCredit(creditID)) return;
        credits.add(new Credit(creditID, type, startPoint, endPoint));
    }

    public boolean containsCredit(Long creditID) {
        return this.credits
                .stream()
                .anyMatch(credit -> credit.getCreditID().equals(creditID));
    }

    // 1) Filter credits by type
    public List<Credit> getCreditsByType(Type type) {
        return null;
    }

    // 2) Find credit by creditID
    public Credit findCredit(Long creditID) {
        return null;
    }

    // 3) Filter credit by start point location
    public List<Credit> getCreditsByStartPoint(Location startPoint) {
        return null;
    }

    // 4) Total of credit's cost
    public double totalCredit() {
        return 0.0;
    }

    // 5) Total of credit's cost with an any location
}

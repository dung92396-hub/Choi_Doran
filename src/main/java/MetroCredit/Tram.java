package MetroCredit;

import java.util.HashMap;
import java.util.Map;

public class Tram {
    private Location location;
    private int position;

    public Tram(Location location, int position) {
        this.location = location;
        this.position = position;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private static Map<Location, Integer> init() {
        Map<Location, Integer> trams = new HashMap<>();
        trams.put(Location.SUOI_TIEN, 1);
        trams.put(Location.DAI_HOC_QUOC_GIA, 2);
        trams.put(Location.THU_DUC, 3);
        trams.put(Location.BINH_THAI, 4);
        trams.put(Location.PHUOC_LONG, 5);
        trams.put(Location.RACH_CHIEC, 6);
        trams.put(Location.AN_PHU, 7);
        trams.put(Location.THAO_DIEN, 8);
        trams.put(Location.TAN_CANG, 9);
        trams.put(Location.VAN_THANH, 10);
        trams.put(Location.BA_SON, 11);
        trams.put(Location.NHA_HAT_THANH_PHO, 12);
        trams.put(Location.BEN_THANH, 13);
        return trams;
    }

    /**
     * Lấy ra độ dài của 2 trạm bắt đầu và kết thúc
     * @param start
     * @param end
     * @return độ dài 2 trạm
     */
    public static int lengthOfTrams(Location start, Location end) {
        var trams = init();
        return trams.get(end) - trams.get(start);
    }

    @Override
    public String toString() {
        return String.format("┌─────────────────────┬────────────────────────────────┐\n" +
                             "│ %-19s │ %-30s │\n" +
                             "├─────────────────────┼────────────────────────────────┤\n" +
                             "│ %-19s │ %-30s │\n" +
                             "│ %-19s │ %-30d │\n" +
                             "└─────────────────────┴────────────────────────────────┘",
                "Tram Information", "",
                "Location", this.location,
                "Position", this.position);
    }
}

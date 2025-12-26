package StudentManager;

import java.time.LocalTime;

public enum ThoiGianHoc {
    CA_1(LocalTime.of(7, 0), LocalTime.of(9, 30)),
    CA_2(LocalTime.of(9, 35), LocalTime.of(12, 5)),
    CA_3(LocalTime.of(12, 15), LocalTime.of(14, 45)),
    CA_4(LocalTime.of(14, 50), LocalTime.of(17, 20)),
    CA_5(LocalTime.of(17, 25), LocalTime.of(19, 25));


    private final LocalTime startTime;
    private final LocalTime endTime;

    ThoiGianHoc(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}

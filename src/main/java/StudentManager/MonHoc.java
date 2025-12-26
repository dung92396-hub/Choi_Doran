package StudentManager;

public class MonHoc {
    private String maMon;           // Mã môn
    private String tenMon;          // Tên môn
    private MonHoc monThucHanh;    // Môn thực hành

    public MonHoc(String maMon, String tenMon, MonHoc monThucHanh) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.monThucHanh = monThucHanh;
    }

    public MonHoc(String maMon, String tenMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.monThucHanh = null;
    }

    // Getters and Setters
    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public MonHoc isMonThucHanh() {
        return monThucHanh;
    }

    public void setMonThucHanh(MonHoc monThucHanh) {
        this.monThucHanh = monThucHanh;
    }
}

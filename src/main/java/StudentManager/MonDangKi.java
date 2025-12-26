package StudentManager;

public class MonDangKi {
    private MonHoc monHoc;
    private CaHoc caHoc;
    private GiangVien giangVien;
    private double diemTrungBinhTongKet;

    public MonDangKi(MonHoc monHoc, CaHoc caHoc, GiangVien giangVien, double diemTrungBinhTongKet) {
        this.monHoc = monHoc;
        this.caHoc = caHoc;
        this.giangVien = giangVien;
        this.diemTrungBinhTongKet = diemTrungBinhTongKet;
    }

    public ThoiGianHoc thoiGianHoc() {
        return caHoc.getThoiGianHoc();
    }

    public int comparingTime(CaHoc caHoc) {
        return caHoc.getThoiGianHoc().comparingTime(caHoc.getThoiGianHoc());
    }

    public boolean isSameCode(MonDangKi other) {
        return other.getMonHoc().getMaMon().equals(this.monHoc.getMaMon());
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public CaHoc getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(CaHoc caHoc) {
        this.caHoc = caHoc;
    }

    public double getDiemTrungBinhTongKet() {
        return diemTrungBinhTongKet;
    }

    public void setDiemTrungBinhTongKet(double diemTrungBinhTongKet) {
        this.diemTrungBinhTongKet = diemTrungBinhTongKet;
    }
}

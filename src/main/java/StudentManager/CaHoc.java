package StudentManager;

public class CaHoc {
    private NgayTrongTuan ngayTrongTuan;
    private ThoiGianHoc thoiGianHoc;

    public CaHoc(NgayTrongTuan ngayTrongTuan, ThoiGianHoc thoiGianHoc) {
        this.ngayTrongTuan = ngayTrongTuan;
        this.thoiGianHoc = thoiGianHoc;
    }

    public int comparingTime(ThoiGianHoc thoiGianHoc) {
        if (thoiGianHoc.getEndTime().isBefore(this.thoiGianHoc.getStartTime())) return -1;
        if (thoiGianHoc.getStartTime().isAfter(this.thoiGianHoc.getStartTime())) return 1;
        return 0;
    }

    public NgayTrongTuan getNgayTrongTuan() {
        return ngayTrongTuan;
    }

    public void setNgayTrongTuan(NgayTrongTuan ngayTrongTuan) {
        this.ngayTrongTuan = ngayTrongTuan;
    }

    public ThoiGianHoc getThoiGianHoc() {
        return thoiGianHoc;
    }

    public void setCaHoc(ThoiGianHoc caHoc) {
        this.thoiGianHoc = caHoc;
    }
}

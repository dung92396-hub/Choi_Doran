package StudentManager;

public class CaHoc {
    private NgayTrongTuan ngayTrongTuan;
    private CaHoc caHoc;

    public CaHoc(NgayTrongTuan ngayTrongTuan, CaHoc caHoc) {
        this.ngayTrongTuan = ngayTrongTuan;
        this.caHoc = caHoc;
    }

    public NgayTrongTuan getNgayTrongTuan() {
        return ngayTrongTuan;
    }

    public void setNgayTrongTuan(NgayTrongTuan ngayTrongTuan) {
        this.ngayTrongTuan = ngayTrongTuan;
    }

    public CaHoc getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(CaHoc caHoc) {
        this.caHoc = caHoc;
    }
}

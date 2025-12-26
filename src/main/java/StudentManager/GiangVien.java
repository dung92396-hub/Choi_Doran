package StudentManager;

public class GiangVien {
    private String maGiangVien;
    private String hoVaTen;

    public GiangVien(String maGiangVien, String hoVaTen) {
        this.maGiangVien = maGiangVien;
        this.hoVaTen = hoVaTen;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }
}

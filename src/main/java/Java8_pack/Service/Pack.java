package Java8_pack.Service;

public class Pack {
    private String packName;
    private double sale;

    public Pack(String packName, double sale) {
        this.packName = packName;
        this.sale = sale;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }
}

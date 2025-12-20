package Java8_pack.AnimalManger;

public class Health {
    private double height;
    private double weight;
    private HeathState heathState;

    public Health(double height, double weight, HeathState heathState) {
        this.height = height;
        this.weight = weight;
        this.heathState = heathState;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public HeathState getHeathState() {
        return heathState;
    }

    public void setHeathState(HeathState heathState) {
        this.heathState = heathState;
    }
}

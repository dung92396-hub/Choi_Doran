package ComputerManager;

public class ComputerConfig {
    private String cpu;      // e.g., Intel i7-12700K
    private int ramGB;       // e.g., 16
    private int storageGB;   // e.g., 512
    private String gpu;      // e.g., RTX 3060

    public ComputerConfig(String cpu, int ramGB, int storageGB, String gpu) {
        this.cpu = cpu;
        this.ramGB = ramGB;
        this.storageGB = storageGB;
        this.gpu = gpu;
    }

    public String getCpu() { return cpu; }
    public int getRamGB() { return ramGB; }
    public int getStorageGB() { return storageGB; }
    public String getGpu() { return gpu; }

    public void setCpu(String cpu) { this.cpu = cpu; }
    public void setRamGB(int ramGB) { this.ramGB = ramGB; }
    public void setStorageGB(int storageGB) { this.storageGB = storageGB; }
    public void setGpu(String gpu) { this.gpu = gpu; }

    @Override
    public String toString() {
        return String.format("CPU: %s, RAM: %dGB, Storage: %dGB, GPU: %s", cpu, ramGB, storageGB, gpu);
    }
}


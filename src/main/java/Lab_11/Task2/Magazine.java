package Lab_11.Task2;

public class Magazine extends Book {
    private String magazineName;

    public Magazine(String title, int pageNum, int publishedYear, String author, int price, String magazineName) {
        super(title, pageNum, publishedYear, author, price);
        this.magazineName = magazineName;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

}

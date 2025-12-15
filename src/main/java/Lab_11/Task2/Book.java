package Lab_11.Task2;

public abstract class Book {
    private String title;
    private int pageNum;
    private int publishedYear;
    private String author;
    private int price;

    public Book(String title, int pageNum, int publishedYear, String author, int price) {
        this.title = title;
        this.pageNum = pageNum;
        this.publishedYear = publishedYear;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

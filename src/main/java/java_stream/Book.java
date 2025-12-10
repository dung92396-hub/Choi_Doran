package java_stream;

public class Book {
    private String title;
    private int pageNumber;
    private int publishYear;

    public Book(String title, int pageNumber, int publishYear) {
        this.title = title;
        this.pageNumber = pageNumber;
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title = ").append(this.title)
                .append("; Page number = ").append(this.pageNumber)
                .append("; Publish year = ").append(this.publishYear);
        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
}

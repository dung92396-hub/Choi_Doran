package Lab_11.Task3;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Nguyễn Văn A", 1980);
        Author author2 = new Author("Trần Thị B", 1985);
        Author author3 = new Author("Lê Văn C", 1975);
        Author author4 = new Author("Phạm Thị D", 1990);

        Book book1 = new Book("B001", "Lập trình Java", 250000, "Kỹ thuật", 2020);
        book1.getAuthors().add(author1);
        book1.getAuthors().add(author2);

        Book book2 = new Book("B002", "Python cơ bản", 200000, "Kỹ thuật", 2021);
        book2.getAuthors().add(author2);

        Book book3 = new Book("B003", "Web Development", 300000, "Kỹ thuật", 2022);
        book3.getAuthors().add(author3);
        book3.getAuthors().add(author4);

        Book book4 = new Book("B004", "Database Design", 280000, "Kỹ thuật", 2020);
        book4.getAuthors().add(author1);
        book4.getAuthors().add(author3);

        Book book5 = new Book("B005", "Mobile App Dev", 320000, "Kỹ thuật", 2023);
        book5.getAuthors().add(author4);

        Library library = new Library("Thư viện Công nghệ");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);


    }
}

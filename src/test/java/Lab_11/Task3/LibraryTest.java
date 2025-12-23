package Lab_11.Task3;


import java.util.List;
import java.util.Map;
import java.util.Set;

class LibraryTest {
    private Library library;
    private Author author1, author2, author3, author4;
    private Book book1, book2, book3, book4, book5;

    @BeforeEach
    void setUp() {
        author1 = new Author("Nguyen Van A", 1980);
        author2 = new Author("Tran Thi B", 1985);
        author3 = new Author("Le Van C", 1990);
        author4 = new Author("Pham Thi D", 1992);

        book1 = new Book("B001", "Java Basics", 200000, "Kỹ thuật", 2018);
        book1.getAuthors().add(author1);
        book1.getAuthors().add(author2);

        book2 = new Book("B002", "Advanced Java", 250000, "Kỹ thuật", 2021);
        book2.getAuthors().add(author2);

        book3 = new Book("B003", "Web Development", 300000, "Kỹ thuật", 2022);
        book3.getAuthors().add(author3);
        book3.getAuthors().add(author4);

        book4 = new Book("B004", "Database Design", 280000, "Kỹ thuật", 2020);
        book4.getAuthors().add(author1);
        book4.getAuthors().add(author3);

        book5 = new Book("B005", "Mobile App Dev", 320000, "Kỹ thuật", 2023);
        book5.getAuthors().add(author4);

        library = new Library("Thư viện Công nghệ");
        library.getBooks().addAll(List.of(book1, book2, book3, book4, book5));
    }
}


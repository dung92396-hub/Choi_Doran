package Lab_11.Task2;

public class Main {
    public static void main(String[] args) {
        Act act1 = new Act("Act 1", 50);
        Act act2 = new Act("Act 2", 75);
        Act act3 = new Act("Act 3", 100);

        ReferenceBook ref1 = new ReferenceBook("Clair Obscur: Expedition 33", 500, 2020, "John Doe", 250000, "Technical");
        ref1.getActs().add(act1);
        ref1.getActs().add(act2);
        ref1.getActs().add(act3);

        ReferenceBook ref2 = new ReferenceBook("Elden Ring", 400, 2021, "Jane Smith", 200000, "Technical");
        ref2.getActs().add(new Act("Chapter 1", 60));
        ref2.getActs().add(new Act("Chapter 2", 80));

        Magazine mag1 = new Magazine("Tech Weekly", 50, 2025, "Editor 1", 50000, "Technology");
        Magazine mag2 = new Magazine("Science Today", 60, 2025, "Editor 2", 60000, "Science");
        Magazine mag3 = new Magazine("Business Monthly", 80, 2024, "Editor 3", 75000, "Business");

        BookManager manager = new BookManager();
        manager.getBooks().add(ref1);
        manager.getBooks().add(ref2);
        manager.getBooks().add(mag1);
        manager.getBooks().add(mag2);
        manager.getBooks().add(mag3);


        System.out.println("Total of books: " + manager.totalOfBookPrice());
        System.out.println(manager.maxActPageNumber());
        System.out.println(manager.containsMagazine("haha"));
        System.out.println(manager.getPublishedBookByYear(2023));
        System.out.println(manager.sortBookByTitleAndYear());
    }
}

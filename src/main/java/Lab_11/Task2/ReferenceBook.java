package Lab_11.Task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReferenceBook extends Book {
    private String type;
    private List<Act> acts;

    public ReferenceBook(String title, int pageNum, int publishedYear, String author, int price, String type) {
        super(title, pageNum, publishedYear, author, price);
        this.type = type;
        acts = new ArrayList<>();
    }

    public int maxActPageNumber() {
        return acts
                .stream()
                .max(Comparator.comparingInt(Act::getPageNum))
                .orElseThrow().getPageNum();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void setActs(List<Act> acts) {
        this.acts = acts;
    }
}

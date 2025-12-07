package Manager;

public class Student {
    private String name;
    private int year;
    private double score;

    public Student(String name, int year, double score) {
        this.name = name;
        this.year = year;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ", " + year + ", " + score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

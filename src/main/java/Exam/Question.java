package Exam;

import java.util.List;

public class Question {
    private String title;
    private List<String> solutions;
    private int correctIndex;

    public Question(String title, List<String> solutions, int correctIndex) {
        this.title = title;
        this.solutions = solutions;
        this.correctIndex = correctIndex;
    }

    public String getCorrectSolution() {
        return this.solutions.get(correctIndex);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<String> solutions) {
        this.solutions = solutions;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public void setCorrectIndex(int correctIndex) {
        this.correctIndex = correctIndex;
    }
}

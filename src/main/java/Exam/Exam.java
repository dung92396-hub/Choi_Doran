package Exam;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    private String title;
    private List<Question> questions;

    public Exam(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    public boolean checkProblem(int quesIdx, int idx) {
        if (quesIdx < 0 || quesIdx >= questions.size()) return false;

        return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}

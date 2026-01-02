package Exam;

import java.util.ArrayList;
import java.util.List;

public class YourExam {
    private Long id;
    private Exam exam;
    private List<Boolean> result;


    public YourExam(Long id, Exam exam) {
        this.id = id;
        this.exam = exam;
        this.result = new ArrayList<>();
    }

    public void doProblem(int questionIndex, int solutionIndex) {
        boolean r = exam.checkProblem(questionIndex, solutionIndex);
        result.add(r);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public List<Boolean> getResult() {
        return result;
    }

    public void setResult(List<Boolean> result) {
        this.result = result;
    }
}

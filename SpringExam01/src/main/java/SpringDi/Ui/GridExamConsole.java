package SpringDi.Ui;

import SpringDi.Entity.Exam;

public class GridExamConsole implements ExamConsole {
    private Exam exam;
    public GridExamConsole(Exam exam) {
        this.exam = exam;
    }

    @Override
    public void print() {

    }
}

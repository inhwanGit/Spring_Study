package SpringDi.Ui;

import SpringDi.Entity.Exam;

public class InlineExamConsole implements ExamConsole {

    private Exam exam;

    public InlineExamConsole(Exam exam) {
        this.exam = exam;
    }

    @Override
    public void print() {
        System.out.printf("total is %d, avg is %f\n", exam.total(),exam.avg());
    }
}

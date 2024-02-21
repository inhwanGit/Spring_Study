package SpringDi;

import SpringDi.Entity.*;
import SpringDi.Ui.ExamConsole;
import SpringDi.Ui.GridExamConsole;
import SpringDi.Ui.InlineExamConsole;

public class Program {
    public static void main(String[] args) {
        Exam exam = new InhwanExam();

        ExamConsole console = new InlineExamConsole(exam);
        console.print();

        ExamConsole console1 = new GridExamConsole(exam);
    }
}

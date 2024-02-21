package SpringDi.Entity;

public class InhwanExam implements Exam{

    private int kor;
    private int eng;
    private int math;
    private int com;

    @Override
    public int total() {
        return kor+eng+math+com;
    }

    @Override
    public float avg() {
        return total()  / 4.0f;
    }
}

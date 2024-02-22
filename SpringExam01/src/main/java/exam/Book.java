package exam;

public class Book {
    String title;
    int price;

    public Book(){} // Spring bean을 사용하기 위해서는 기본생성자가 존재해야한다.
    public Book(String title, int price){
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

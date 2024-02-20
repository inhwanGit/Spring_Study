package exam;

import java.io.IOException;

public class ApplicationContextMain {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ApplicationContext();
        Book book = new Book("즐거운 자바", 10000);
        System.out.println(book.getTitle());
        System.out.println(book.getPrice());
    }
}

package exam;

import java.io.IOException;

public class ApplicationContextMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ApplicationContext context = ApplicationContext.getInstance();
        Book book = (Book) context.getBean("book1"); // id에 해당하는 인스턴스를 달라.
        book.setPrice(5000);
        book.setTitle("즐거운 자바");

        System.out.println(book.getPrice());
        System.out.println(book.getTitle());

        System.out.println("-------------------");
        Book book1 = (Book) context.getBean("book1");
        System.out.println(book1.getTitle());

        if(book == book1){
            System.out.println("같은 인스턴스");
        }else {
            System.out.println("디른 인스턴스");
        }

    }
}

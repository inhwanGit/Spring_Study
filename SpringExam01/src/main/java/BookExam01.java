public class BookExam01 {
    public static void main(String[] args) {
        Book book = new Book("즐거운 스프링", 1000);
        System.out.println(book.getTitle());
        System.out.println(book.getPrice());
    }
}

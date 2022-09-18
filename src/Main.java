import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1. Using Java Stream API find out sum of all numbers between 1 and 10000 that are dividable by both 3 and 5 but not dividable by 7

        int sum =IntStream.range(1,1001)
                .filter(i -> (i%3 == 0)&&(i%5==0)&&(i%7!=0))
                .sum();


        //2. Using Java Stream API print first 100 even numbers that are not dividable by 8
        IntStream.range(1,101)
                .filter(i -> (i%2 == 0)&&(i%8!=0))
                .forEach(A->System.out.println("Even number not dividable by 8: "+A));

        //3.Lets assume we have the following class Book:

        Book book1=new Book("Bylinky",500);
        Book book2=new Book("Abeceda",80);
        Book book3=new Book("Book",300);
        Book book4=new Book("Kucharka",100);
        Book book5=new Book("Hra o trony",50);


        //3.1 Using Java Stream API print names (in alphabetic order) of all books that have price smaller than 100.
        Stream.of(book1,book2,book3,book4,book5).sorted(Comparator.comparing(Book::getName)).filter(i->i.getPrice()<100).forEach(A->System.out.println(A.getName()));


        //3.2 Using Java stream API find out how many books have name shorter than 5 characters.
        Stream.of(book1,book2,book3,book4,book5).filter(i->i.getName().length()<5).forEach(A->System.out.println(A.getName()));


        //3.3 Using Java stream API find out what is the average price of the book in the list
        IntStream stream = IntStream.of(book1.getPrice(),book2.getPrice(),book3.getPrice(),book4.getPrice(),book5.getPrice());
        OptionalDouble obj = stream.average();
//        System.out.println(obj.getAsDouble());

        //3.4 Using Java stream API find out if all books in list are cheaper than 500
        boolean isCheaper= Stream.of(book1,book2,book3,book4,book5).allMatch(i->i.getPrice()<500);
//        System.out.println(isCheaper);



    }
}

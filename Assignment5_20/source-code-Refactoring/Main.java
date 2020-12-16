import java.util.Date;

public class Main {
    public static void main (String[] args) {
        Customer C1;
        Customer C2;
        Customer C3;


        Movie M1;
        Movie M2;
        Movie M3;

        C1 = new Customer("John");
        C2 = new Customer("Mary");
        C3 = new Customer("Manny");


        M1 = new Movie("Oz The Great and Powerful", Movie.NEW_RELEASE);
        M2 = new Movie("The Dark Knight", Movie.REGULAR);
        M3 = new Movie("Wreck-it Ralph", Movie.CHILDRENS);

        Date start = new Date(2013, 7, 1);
        Date end1 = new Date(2013, 7, 6);
        Date end2 = new Date(2013, 7, 4);
        Date end3 = new Date(2013, 7, 5);
        C1.addRental(new Rental(M1, new range(start, end1)));
        C1.addRental(new Rental(M2, new range(start, end2)));
        C1.addRental(new Rental(M3, new range(start, end3)));
        System.out.println(C1.statement());
        System.out.println();

        start = new Date(2013, 7, 11);
        end1 = new Date(2013, 7, 12);
        end2 = new Date(2013, 7, 19);
        C2.addRental(new Rental(M1, new range(start, end1)));
        C2.addRental(new Rental(M3, new range(start, end2)));
        System.out.println(C2.statement());
        System.out.println();

        start = new Date(2013, 6, 1);
        end1 = new Date(2013, 6, 3);
        end2 = new Date(2013, 6, 2);
        C3.addRental(new Rental(M2, new range(start, end1)));
        C3.addRental(new Rental(M3, new range(start, end2)));
        System.out.println(C3.statement());
        System.out.println();
    }
}

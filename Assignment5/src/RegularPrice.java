package src;

public class RegularPrice extends Price {
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    protected double getCharge(int daysRented) {
        // determine amounts for each line
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
    @Override
    protected int getFrequentRenterPoints(int number) {
        return 0;
    }
}
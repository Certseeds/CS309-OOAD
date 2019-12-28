package src;

public class NewReleasePrice extends Price {
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    protected double getCharge(int daysRented) {
        // determine amounts for each line
        return daysRented * 3;
    }
    protected int getFrequentRenterPoints(int number) {
        return (number > 1)?1:0;
    }
}

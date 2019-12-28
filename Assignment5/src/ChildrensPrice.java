package src;

public class ChildrensPrice extends Price {
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    protected double getCharge(int daysRented) {
        // determine amounts for each line
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
    @Override
    protected int getFrequentRenterPoints(int number) {
        return 0;
    }
}

public class NewReleasePrice extends Price {
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double amountFor(int daysRented) {
        return daysRented * 3;
    }
    @Override
    public int getFrequentRenterPoints(int days) {
        return (days > 1) ? 1: 0;
    }
}

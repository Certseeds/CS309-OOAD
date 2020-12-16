public abstract class Price {
    public abstract int getPriceCode();

    public abstract double amountFor(int daysRented);

    public int getFrequentRenterPoints(int days) {
        return 0;
    }

}

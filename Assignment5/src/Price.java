package src;

public abstract class Price {

    public Price() {
        super();
    }

    public abstract int getPriceCode();

    protected abstract double getCharge(int daysRented);
    
    protected abstract int getFrequentRenterPoints(int number);
}
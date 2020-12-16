public class RegularPrice extends Price {
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double amountFor(int daysRented) {
        var result = 2.0f;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
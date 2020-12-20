class Rental {


    Movie _movie;
    private final int _daysRented;

    public Rental(Movie movie, range range) {
        _movie = movie;
        _daysRented = range.getRangeDistance();
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    public double amountFor() {
        return _movie.amountFor(_daysRented);
    }

    public String getTitle() {
        return _movie.get_title();
    }

    public int getPriceCode() {
        return _movie.get_price();
    }

    public int getFrequentRenterPoints() {
        return this._movie.getFrequentRenterPoints(this.get_daysRented());
    }
}

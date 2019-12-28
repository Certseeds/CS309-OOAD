package src;

class Rental {
    private Movie _movie;
    private int _daysRented;
    public Movie getMovie() {
        return this._movie;
    }
    public void setMovie(Movie movie) {
        this._movie = movie;
    }
    public Rental(Movie movie, DataRange range) {
        _movie = movie;
        _daysRented = (int)((range.getEnd().getTime() - range.getStart().getTime()) / (1000 * 60 * 60 * 24));
    }
    public int getDaysRented() {
        return _daysRented;
    }

    public String getTitle() {
        return _movie.getTitle();
    }
    
    public int getPriceCode() {
        return _movie. getPriceCode();
    }
    double getCharge() {
        return this._movie.getCharge(this._daysRented);
    }
    public int getFrequentRenterPoints() {
        return 1+_movie.getFrequentRenterPoints(getDaysRented());
        // add bonus for a two day new release rental
    }
}

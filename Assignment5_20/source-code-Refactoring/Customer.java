import java.util.Vector;

class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental rental : _rentals) {
            // add frequent renter points
            //show figures for this rental
            result.append("\t").append(rental.getTitle());
            result.append("\t").append(String.valueOf(rental.amountFor()));
            result.append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(getTotalCharge()));
        result.append("\n");
        result.append("You earned ").append(String.valueOf(getTotalFrequentRenterPoints()));
        result.append(" frequent renter points");
        return result.toString();
    }

    public double getTotalCharge() {
        double result = 0;
        for (Rental each : _rentals) {
            result += each.amountFor();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int total_freq = 0;
        for (Rental each : _rentals) {
            total_freq += each.getFrequentRenterPoints();
        }
        return total_freq;
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<H1>Rentals for <EM>").append(getName());
        result.append("</EM></H1><P>\n");
        for (Rental each : _rentals) {//show figures for each rental
            result.append(each.get_movie().get_title()).append(": ");
            result.append(String.valueOf(each.amountFor())).append("<BR>\n");
        }
        result.append("<P>You owe <EM>").append(String.valueOf(getTotalCharge()));
        result.append("</EM><P>\n");
        result.append("On this rental you earned <EM>");
        result.append(String.valueOf(getTotalFrequentRenterPoints()));
        result.append("</EM> frequent renter points<P>");
        return result.toString();
    }

}

import java.util.Date;

public class range {
    private final Date start;
    private final Date end;

    public range(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public int getRangeDistance() {
        return  (int) ( this.getEnd().getTime() - this.getStart().getTime()) / (1000 * 60 * 60 * 24);
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}

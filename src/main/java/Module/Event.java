package Module;

public class Event extends item{

    protected String by;

    public Event(String info, Boolean status, String by) {
        super(info, status);
        this.by = by;
    }

    public String getDate () {
        return by;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + by + ")";
    }
}
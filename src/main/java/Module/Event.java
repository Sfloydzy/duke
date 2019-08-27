package Module;

public class Event extends item{

    protected String by;

    public Event(String info, Boolean status, int index, String by) {
        super(info, status, index);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + by + ")";
    }
}
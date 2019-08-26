public class Event extends item{

    protected String by;

    public Event(String info, int index, String by) {
        super(info, index);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + by + ")";
    }
}
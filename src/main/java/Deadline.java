public class Deadline extends item{

    protected String by;

    public Deadline(String info, int index, String by) {
        super(info, index);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

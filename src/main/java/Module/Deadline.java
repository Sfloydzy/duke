package Module;

public class Deadline extends item{

    protected String by;

    public Deadline(String info, Boolean status, int index, String by) {
        super(info, status, index);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

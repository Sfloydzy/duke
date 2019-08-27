package Module;

public class Deadline extends item{

    protected String by;

    public Deadline(String info, Boolean status, String by) {
        super(info, status);
        this.by = by;
    }

    public String getDate () {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

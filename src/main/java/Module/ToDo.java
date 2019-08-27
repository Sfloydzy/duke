package Module;

public class ToDo extends item {

    public ToDo(String info, Boolean status) {
        super(info, status);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

package Module;

public class ToDo extends item {

    public ToDo(String info, Boolean status, int index) {
        super(info, status, index);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

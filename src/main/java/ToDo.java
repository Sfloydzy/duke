public class ToDo extends item {

    public ToDo(String info, int index) {
        super(info, index);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

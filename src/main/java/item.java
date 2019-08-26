public class item {

    private int index;
    private Boolean status;
    private String info;


    public item (String info, int index) {
        this.index = index;
        this.status = false; //true or false
        this.info = info;
    }

    public Boolean changeStatus () {
        status = true;
        return true;
    }

    public int getIndex() {
        return this.index;
    }

    public String getInfo() {
        return this.info;
    }

    public String getStatusIcon() {
        return (status ? "\u2713" : "\u2718"); //return tick or X symbols
    }
}
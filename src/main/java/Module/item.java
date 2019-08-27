package Module;

public class item {

    private int index;
    private Boolean status;
    private String info;


    public item (String info, Boolean status, int index) {
        this.index = index;
        this.status = status; //true or false
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
    public String toString() {
        String s =   "[" + this.getStatusIcon() + "] " + this.getInfo();
        return s;
    }
}
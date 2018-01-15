package Main;

public class StringPrint implements Print {
    private String str;

    public StringPrint(String str) {
        this.str = str;
    }

    @Override
    public void print() {
        System.out.print(this.str);
    }
}

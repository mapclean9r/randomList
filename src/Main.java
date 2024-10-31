public class Main {
    public static void main(String[] args) {

        randomList<String> c = new randomList<>();

        c.add("egg");
        c.add("soap");
        c.add("ion");
        c.add("dean");

        c.printListForm();
        System.out.print("\n");

        System.out.println(c.pick());

        c.printListForm();
    }
}
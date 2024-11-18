public class Main {
    public static void main(String[] args) {

        GambleList<String> c = new GambleList<>();

        c.add("egg").add("soap").add("ion").add("dean").printListForm();

        System.out.println("Your Roll: " + c.roll());

        c.printListForm();
    }
}
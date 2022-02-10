public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.append("text", 2);
        printer.append("text2",1,"title",2);
        printer.clear();
        printer.append("text", 2);
        printer.append("text2",2,"title",2);
        printer.print("");

        printer.append("text", 2);
        printer.print("");

    }
}

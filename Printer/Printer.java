public class Printer {
    private static int countDocs = 0;
    private String queue = "";
    private static int pendingPagesCount = 0;
    private int totalPages = 0;
    private int limit;

    public Printer() {
        increaseCount(1);
        queue = "Список очереди на печать:";
        this.limit = 500;
    }
    public Printer(String queue, int pendingPagesCount) {
        this();
        this.queue = this.queue + queue;
        this.pendingPagesCount = pendingPagesCount;

    }
    public static void increaseCount(int pendingPagesCount) {
        Printer.pendingPagesCount = Printer.pendingPagesCount + pendingPagesCount;
    }
        public void append (String text,int countDocs){

            append(text, countDocs, "нет", 1);
        }
        public void append (String text,int countDocs,String title){
            append(text, countDocs, title,1);

        }
        public void append (String text,int countDocs, String title, int pages){
            boolean error = false;
            if (contains(text)) {
                error = true;
            }

            if (pendingPagesCount+ countDocs * pendingPagesCount >= limit) {
                error = true;
            }

            if (error) {
                System.out.println("Error occured :(");
                return;
            }

            queue = queue + "\n" + text + ", заглавие: " + title + ", " + " Количество документов: " + " - " +
                    countDocs + " шт. - " + pages + " стр.";

            pendingPagesCount = pendingPagesCount + countDocs * pages;

        }

        public void clear () {
            queue = "";
            pendingPagesCount = 0;


        }
        public int getPendingPagesCount () {

            return pendingPagesCount;
        }

    public boolean contains(String text) {

        return queue.contains(text);
    }
        public void print(String text){
            System.out.println(text);
            if (queue.isEmpty()) {
                System.out.println("Очередь на печать пуста");
            } else {

                System.out.println(queue);
                totalPages = totalPages + pendingPagesCount;
                }

            System.out.println("\nКоличество страниц на печати - " + pendingPagesCount +
                    "\nОбщее количество распечатанных страниц - " + totalPages);
            queue = "";
            pendingPagesCount = 0;
        }
    }

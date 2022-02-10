
public class Arithmetic {
    private int x;
    private int y;
    private int sum = 0;
    private int multiply = 0;
    private int max = 0;
    private int min = 0;

    public Arithmetic(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void sum() {
        sum = x + y;
    }

    public void multiply() {
        multiply = x * y;
    }

    public void getMaxMin() {

        if (x < y) {
            max = y;
            min = x;
        } else {
            max = x;
            min = y;
        }
    }
    public void print() {
        System.out.println("сумма: " + sum + "\n" + "Произведение: " + multiply + "\n" + "Максимальное число: " + max + "\n" + "Минимальное число: " + min);
    }

}






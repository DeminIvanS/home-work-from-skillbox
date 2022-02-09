
public class Arithmetic {
    private int sum = 0;
    private int multiply = 0;
    private int max = 0;
    private int min = 0;

    public void sum(int x, int y) {
        sum = x + y;
    }

    public void multiply(int x, int y) {
        multiply = x * y;
    }

    public void getMaxMin(int x, int y) {

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






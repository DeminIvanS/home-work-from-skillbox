public class Basket {

    private static int countGoods = 0;
    private static int totalCountGoods = 0;
    private static int totalPriceGoods = 0;
    private static int countBasket = 0;
    private static double averagePriceBasket = 0;
    private static double averagedPriceGoods = 0;

    private double totalWeight = 0.0;
    private int totalCountGoodsInBasket = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double averagePriceGoodsInBasket = 0;



    public Basket() {
    increaseCount(1);
    countBasket = countBasket + 1;
    items = "Список товаров:";
    this.limit = 1000000;
    }

    public Basket(int limit) {
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCountGoods() {
       return countGoods;
    }

    public static int getCountBasket(){
        return countBasket;
        }

    public static void increaseCount(int count) {
        Basket.countGoods = Basket.countGoods + countGoods;
    }
    public static double getAveragedPriceBasket() {
        return averagePriceBasket = totalPriceGoods/countBasket;
    }
    public static double getAveragedPriceGoods(){
        return averagedPriceGoods = (double) totalPriceGoods/totalCountGoods;
    }


    public void add(String name, int price) {

        add(name, price, 1,0.0);
    }
    public void add(String name, int price, int countGoods) {
        add(name, price,countGoods,0.0);

    }
    public void add(String name, int price, int countGoods, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }
        if (totalPrice + countGoods * price >= limit) {
            error = true;
        }
        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " +
                countGoods + " шт. - " + price + "руб. - " + weight + "кг";
        totalPrice = totalPrice + countGoods * price;
        totalWeight = totalWeight + weight * countGoods;
        totalCountGoodsInBasket = totalCountGoodsInBasket + countGoods;
        totalCountGoods = totalCountGoods + countGoods;
        totalPriceGoods = totalPriceGoods + countGoods * price;
        averagePriceGoodsInBasket = totalPrice/totalCountGoodsInBasket;

    }


    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
        System.out.println("\nОбщая стоимость товаров в корзине: " + totalPrice +
                "\nОбщий вес товаров в корзине: " + totalWeight + "\nСредняя цена товара: " +
                averagePriceGoodsInBasket + "\nКоличество товаров в корзине: " + totalCountGoodsInBasket);
    }

}

public class Main {

    public static void main(String[] args) {
        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Молоко", 40, 2);
        vasyaBasket.add("Coffee", 400, 1, 0.5);
        vasyaBasket.add("Носки", 200, 2, 0.1);
        Basket kolyaBasket = new Basket();
        kolyaBasket.add("Молоко", 40, 2);
        kolyaBasket.add("Coffee", 400, 1, 0.5);
        kolyaBasket.add("Лопата", 1000, 2, 1);
        kolyaBasket.print("Корзина Коли");
        vasyaBasket.print("\nКорзина Васи");
        System.out.println("\nСредняя цена корзины: " + Basket.getAveragedPriceBasket());
        System.out.println("Средняя цена товара: " + Basket.getAveragedPriceGoods());


    }

}

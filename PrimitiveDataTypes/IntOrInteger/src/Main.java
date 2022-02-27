public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.
        for (int i = 0; i < 65536; i++) {
            char c = (char) i;
            if(i >= 'А' && i <= 'я') {
                System.out.println(i + " - " + c);
            }
        }
        char c1 = 'ё';
        char c2 = 'Ё';
        int charCode = c1;
        int charCode2= c2;

        System.out.println(charCode + " - " + c1);
        System.out.println(charCode2 + " - " + c2);
}}

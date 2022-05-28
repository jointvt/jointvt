import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a =scanner.nextInt();
        System.out.println(a + "первое число");
        System.out.println("Введите второе число");
        int b =scanner.nextInt();
        int c = a / b;
        System.out.println("Ответ: " + c);

    }
}

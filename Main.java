import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет.");
        Scanner in = new Scanner(System.in);
        System.out.println("Калькулятор принимает на вход строку в формате \"a + b\"." +
                "\nРимские и арабские числа от 1 до 10 включительно." +
                "\nПоддерживаемые операции: +, -, *, /." +
                "\nВведите строку для калькулятора: ");
        String str = in.nextLine();
        System.out.println(Calculator.calculator(str));
    }
}

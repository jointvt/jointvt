import java.util.Scanner;

public class SSS {
    public static void main(String[] args) {
        System.out.println("Input:");
        Scanner number = new Scanner(System.in);
        Numbers num = new Numbers();

        String[] array = number.nextLine().split("");
        if (array.length !=3) {
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            String num1 = array[0];
            String operationS = array[1];
            String num2 = array[2];

            num.num1 = num1;
            num.operation = operationS.charAt(0);
            num.num2 = num2;

            num.existR();   // конвертация в int для римских
            num.convertIntRo();
            num.existR2();
            num.convertIntRo2();

            num.exist();    // конвертация в int для арабских
            num.convertIntAr();
            num.exist2();
            num.convertIntAr2();

            num.checkNums();


            if (num.exist() && num.exist2()) {
                System.out.println(num.calculation());
            } else if (num.exist() && num.existR2()) {  // посмотри логические операторы!!!!
                System.out.println("Используются одновременно разные системы счисления");
        } else if (num.exist2() && num.existR()) {
                System.out.println("Используются одновременно разные системы счисления");
            } else if (num.existR() && num.existR2()) {
                num.calculation();
                try {
                    num.res();
                    System.out.println(num.res());
                } catch (ArithmeticException e) {
                    System.out.println("throws Exception //т.к в римской системе нет отрицательных чисел и нуля");
                }

                }
            }
    }
}
class Numbers {

    String num1;
    String num2;

    char operation;

    int numInt1;
    int numInt2;

    int result;

    RomanNumeral resultRo;

    String[] numArabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] numRoman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    boolean exist() {
        for (String s : numArabic) {
            if (num1.equals(s)) {
            return true;
        }
    }
    return false;
}
    boolean exist2() {
    for (String s : numArabic) {
        if (num2.equals(s)) {
            return true;
        }
    }
    return false;
    }

int convertIntAr() {
    if (exist()) {
        numInt1 = Integer.parseInt(num1);
    }
    return numInt1;
}
    int convertIntAr2() {
        if (exist2()) {
            numInt2 = Integer.parseInt(num2);
    }
    return numInt2;
}
boolean existR() {
    for (String v : numRoman) {
        if(num1.equals(v)) {
            return true;
        }
    }
    return false;
}
boolean existR2() {
    for (String v : numRoman) {
        if (num2.equals(v)) {
            return true;
        }
    }
    return false;
}
int convertIntRo() {
    if (existR()) {
        RomanNumeral one = RomanNumeral.valueOf(num1);
        numInt1 = one.getArabic();
    }
    return numInt1;
}
int convertIntRo2() {
    if (existR2()) {
        RomanNumeral two = RomanNumeral.valueOf(num2);
        numInt2 = two.getArabic();
    }
    return numInt2;
}
boolean checkNums () {
    if (numInt1 > 10 || numInt1 <= 0) {
        System.out.println("Необходимо ввести числа от 1(I) до 10(X)");
    } else if (numInt2 > 10 || numInt2 <= 0) {
        System.out.println("Необходимо ввести числа от 1(I) до 10(X)");
    }
    return false;
}


     int calculation() {
    switch (operation) {
        case '+':
            result = numInt1 + numInt2;
            break;
        case '-':
            result = numInt1 + numInt2;
            break;
        case '*':
            result = numInt1 + numInt2;
            break;
        case '/':
            result = numInt1 + numInt2;
            break;
        default:
            System.out.println("Вы указали неверную операцию");
    }
    return result;
     }


     RomanNumeral res() {
    resultRo = RomanNumeral.values()[result - 1];
    return resultRo;
     }
}

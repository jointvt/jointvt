import java.util.Scanner;

public class Calculator {

    int a, b , c;
    int summa (int a, int b){
        int c = a+b;
        return c;

    }
    int raznost (int a, int b){
        int c = a-b;
        return c;
    }
    int umnojit (int a, int b){
        int c = a*b;
        return c;
    }

    int delenie (int a, int b){
        int c = a/b;
        return c;
    }

}
class Arabskeshisla {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 2 числа и операцию, которую вы хотите с ним совершить: ");
        String name = in.nextLine();
        String[] split = name.split(" ");
        String sa = split[0];
        String ss = split[1];
        String sb = split[2];
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",};
        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
                "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
                "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
                "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
                "91", "92", "93", "94", "95", "96", "97", "98", "99", "100",};
        if ((sa.equals("I"))||(sa.equals("II"))||(sa.equals("III"))||(sa.equals("IV"))||(sa.equals("V"))||(sa.equals("VI"))||(sa.equals("VII"))||(sa.equals("VIII"))||(sa.equals("IX"))||(sa.equals("X"))) {
            if ((sb.equals("I")) || (sb.equals("II")) || (sb.equals("III")) || (sb.equals("IV")) || (sb.equals("V")) || (sb.equals("VI")) || (sb.equals("VII")) || (sb.equals("VIII")) || (sb.equals("IX")) || (sb.equals("X"))) {

                int j = 0;
                int i = 0;

                for (i = 0; i < rim.length; ++i) {
                    if (rim[i].equals(sa))
                        j = i;
                    if (rim[i] == sa);

                }
                String sa1 = arab [j];
                for (i = 0; i < rim.length; ++i) {
                    if (rim[i].equals(sb))
                        j=i;
                    if (rim[i] == sb) ;
                }
                String sb1 = arab[j];

                Calculator c2 = new Calculator();
                int a1 = Integer.parseInt(sa1);
                int b1 = Integer.parseInt(sb1);
                if (ss.equals("+")) {
                    int c = c2.summa(a1, b1);
                    String sum = Integer.toString(c);
                    for (j = 0; j < arab.length; ++j) {
                        if (arab[j].equals(sum)) {
                            i = j;
                            System.out.printf("rim[i]");
                        }
                    }
                } else if (ss.equals("-")) {
                    int c = c2.raznost(a1, b1);
                    String raz = Integer.toString(c);
                    for (j = 0; j < arab.length; ++j) {
                        if (arab[j].equals(raz)) {
                            i = j;
                            System.out.println(rim[i]);
                        }
                    }
                } else if (ss.equals("*")) {
                    int c = c2.umnojit(a1, b1);
                    String um = Integer.toString(c);
                    for (j = 0; j < arab.length; ++j) {
                        if (arab[j].equals(um)) {
                            i = j;
                            System.out.println(rim[i]);
                        }
                    }
                } else if (ss.equals("/")) {
                    int c = c2.delenie(a1, b1);
                    String del = Integer.toString(c);
                    for (j = 0; j < arab.length; ++i); {
                        if (arab[j].equals((del))) {
                            i = j;
                            System.out.println(rim[i]);

                        }
                    }
                } else {
                    System.out.println("Вы не ввели знак действия");
                }
            } else {
                Calculator c1 = new Calculator();
                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);

                if ((a <= 10) && (b <= 10)) {
                    if ((a >= 1) && (b >= 1)) {
                        if (ss.equals("+")) {
                            int c = c1.summa(a, b);
                            System.out.println(c);
                        } else if (ss.equals("-")) {
                            int c = c1.raznost(a,b);
                            System.out.println(c);
                        } else if (ss.equals("*")) {
                            int c = c1.umnojit(a, b);
                            System.out.println(c);
                        } else if (ss.equals("/")) {
                            int c = c1.delenie(a, b);
                            System.out.println(c);
                        } else {
                            System.out.println("Вы не ввели знак действия!");
                        }
                    }
                }
            }
        }
    }
}

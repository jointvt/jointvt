import java.util.List;

public class RomanArabicConvert {
    public static int romantoArabic(String input) {
        String romanNumber = input.toUpperCase();
        int result = 0;
        List<RomanNumbers> romanNumbers = RomanNumbers.getReverseSortedValues();
        int i = 0;
        while ((romanNumber.length() > 0) && (i < romanNumbers.size())) {
            RomanNumbers symbol = romanNumbers.get(i);
            if (romanNumber.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            }else {
                i++;
            }
        }
        if (romanNumber.length() > 0) {
            throw new IllegalArgumentException(input + " не является римским числом. Завершение работы.");
        }
        Calculator.check(result);
        return result;
    }
    public static String arabicToRoman(int num) {
        List<RomanNumbers> romanNumbers = RomanNumbers.getReverseSortedValues();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((num > 0) && (i < romanNumbers.size())) {
            RomanNumbers currentSymbol = romanNumbers.get(i);
            if (currentSymbol.getValue() <= num) {
                sb.append(currentSymbol.getValue());
                num -= currentSymbol.getValue();
            }else {
                i++;
            }
        }
        return sb.toString();
    }
}

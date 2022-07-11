import java.util.Scanner;
import java.io.*;
public class calc
{
    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(System.in);
            System.out.println(calc(in.nextLine())); // чтение строки из консоли, запуск метода calc
        }
        catch(Exception e){
            System.out.println(e.getMessage()); // вывод ошибок
        }
    }
    public static String calc(String input) throws Exception {

        String[] inputData = new String[3]; // создаём наш массив
        if(input.contains("\"")){ // если в нашей строке исходной есть кавычки
            String[] operators = {"+","-","*","/"} ; // все наши операторы
            for (int i = 0; i < operators.length; i++){
                if(input.contains(" " + operators[i] + " ")){ // ищем их в строке
                    inputData[0] = input.substring(0,input.indexOf(" " + operators[i] + " ")); // обрезаем данные
                    inputData[1] = operators[i]; // присваиваем оператор
                    inputData[2] = input.substring(inputData[0].length() + 3, input.length()); // получаем последний элемент
                    break;
                }
            }
        }
        else{
            inputData = input.split(" "); // разделяем входную строку по пробелам, в нашем случае должно быть 3 элемента
            if((inputData.length != 3)){
                throw new Exception("Не верный формат строки.\nДоступно только два операнда и один оператор (+, -, /, *).");
            }
        }
        String operator = inputData[1]; // присваиваем оператор
        if((inputData[0].charAt(0) == '\"') && (inputData[0].charAt(inputData[0].length() - 1) == '\"')){ // если первый элемент имеет кавычки
            if((inputData[0].length() > 12) && (inputData[2].length() > 12)){ // 12 тк 2 символа - кавычки
                throw new Exception("Привышена длинна строки, лимит = 10 символов.");
            }
            String first = inputData[0].replace("\"",""); // удаляем кавычки
            String second = inputData[2];
            if((second.length() != 1)&&(second.charAt(0) == '\"') && (second.charAt(second.length() - 1) == '\"')){ // если второй элемент имеет кавычки

                second = inputData[2].replace("\"",""); // удаляем кавычки
                switch (operator){
                    case "+":
                        return getAnswerString(first + second); // сложение
                    case "-":
                        return getAnswerString(first.replace(second,"")); // вычитание
                    case "*":
                        throw new Exception("При умножении второй операнд - число в диапозоне [1..10].");
                    case "/":
                        throw new Exception("При делении второй операнд - число в диапозоне [1..10].");
                    default: //если такого оператора нет
                        throw new Exception("Не верный формат оператора.\nОператор должен быть (+, -, /, *).");
                }
            }
            else if (!second.contains("\"")){ // если второй элемент не имеет кавычек
                int num = tryParse(inputData[2]); // получаем число
                if((num < 1) || (num > 10)){ //  проверка на принадлежность диапозону [1..10]
                    throw new Exception("Не верный формат операндов.\nЕсли операнд - число, он должен принадлежать диапозону [1..10].");
                }
                switch (operator){
                    case "+":
                        throw new Exception("При сложении второй операнд - строка в \"кавычках\".");
                    case "-":
                        throw new Exception("При вычитании второй операнд - строка в \"кавычках\".");
                    case "*":
                        return  getAnswerString(first.repeat(num)); // умножении
                    case "/":
                        return getAnswerString(first.substring(0,first.length() / num)); // деление
                    default: //если такого оператора нет
                        throw new Exception("Не верный формат оператора.\nОператор должен быть (+, -, /, *).");
                }
            }
            else {
                throw new Exception("Не верный формат операндов.\nОба операндов должны являться строкой в \"кавычках\".");
            }
        }
        else { // первый элемент - число
            throw new Exception("Не верный формат операндов.\nОба операндов должны являться строкой в \"кавычках\".");
        }
    }
    private static int tryParse(String value){ // перевод строки в число
        try {
            return Integer.parseInt(value); // перевод удался
        }
        catch (NumberFormatException e) {
            return 0; // перевод не удался
        }
    }
    private static String getAnswerString(String value){
        return "\"" + ((value.length() <= 40) ? value : (value.substring(0,40) + "...")) + "\""; // заключаем ответ в кавычки 
    }
}

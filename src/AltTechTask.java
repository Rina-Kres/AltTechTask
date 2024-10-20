import java.util.Scanner;
public class AltTechTask {
    public static void main(String[] args) throws Exception {
        calcText();
    }

    public static void calcText() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите текст");
        String exp = scn.nextLine();
        char c = exp.charAt(0);
        if (c >= '1' && c <= '9') {
            throw new Exception("Строка не может начинаться с числа");
        }
        if (exp.length() > 10) {
            throw new Exception("Введите не более 10 символов");
        }
        char action = getAction(exp);
        String[] data;
        data = getData(exp, action);

        if (exp.contains("+")) {
            data = exp.split("\\+");
            action = '+';
        } else if (exp.contains("-")) {
            data = exp.split("-");
            action = '-';
        } else if (exp.contains("*")) {
            data = exp.split("\\*");
            action = '*';
        } else if (exp.contains("/")) {
            data = exp.split("/");
            action = '/';
        } else {
            throw new Exception("Некорректный знак");
        }
        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Умножение и деление возможно на число без кавычек");
        }
        for (int i = 0; i <exp.length(); i++){
            try {
                int num = Integer.parseInt(data[i].trim());
                if (num < 1 || num > 10) {
                    throw new Exception("Допустимый диапазон чисел: от 1 до 10");
                }
            } catch (NumberFormatException e) {
                throw new Exception("Допустимый диапазон чисел: от 1 до 10");
            }
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        if (action == '+') {
            print(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            print(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                print(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                print(result);
            }
        } else {
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, newLen);
            print(result);
        }
    }

    private static String[] getData(String exp, char action) {
        return new String[0];
    }

    private static char getAction(String exp) {
        return 0;
    }

    static void print(String text) {
        System.out.println("\"" + text + "\"");
    }
}

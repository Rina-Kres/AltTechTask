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
        if (c != '"') try {
            throw new Exception("Некорректное выражение");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String[] data;
        char action;
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некооректный знак действия");
        }

        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Умножение и деление возможно на число без кавычек");
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (action == '+') {
            print(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            if (multiplier < 1 || multiplier > 10) try {
                throw new Exception("Допустимый диапазон чисел от 1 до 10");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
            if (newLen < 1 || newLen > 10) try {
                throw new Exception("Допустимый диапазон чисел от 1 до 10");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String result = data[0].substring(0, newLen);
            print(result);
        }
    }

    static void print(String text) {
        if (text.length() > 40) {
            System.out.println("\"" + text.substring(0, 40) + "..." + "\"");
        } else System.out.println("\"" + text + "\"");
    }
}
import java.sql.SQLOutput;
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
        if (c != '"') throw new Exception("Некорректное выражение");

        String[] data = exp.split(" ");
        if (data.length != 3) throw new Exception("Введите действие");

        if (data[0].length() > 10 || data[2].length() > 10) throw new Exception("Не больше 10 символов");

//            throw new Exception("Некорректный знак");

        if (data[1].equals("*") || data[1].equals("/")) {
            if (data[2].contains("\"")) throw new Exception("Умножение и деление возможно на число без кавычек");
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
            if (data[1].equals("+")) {
            print(data[0] + data[2]);
        } else if (data[1].equals("*")) {
            int multiplier = Integer.parseInt(data[2]);
            if (multiplier <1 || multiplier >10) throw new Exception("Допустимый диапазон чисел от 1 до 10");
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }

            print(result);
        } else if (data[1].equals("-")) {
            int index = data[0].indexOf(data[2]);
            if (index == -1) {
                print(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[2].length());
                print(result);
            }

        } else {
            int newLen = data[0].length() / Integer.parseInt(data[2]);
            if (newLen <1 || newLen >10) throw new Exception("Допустимый диапазон чисел от 1 до 10");
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

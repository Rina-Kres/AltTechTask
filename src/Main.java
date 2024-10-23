import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String exp = scn.nextLine();
            StringBuilder sb = new StringBuilder();
            for (char c : exp.toCharArray()){
                if(Character.isDigit(c)){
                    sb.append(c);
                }
            }
        }
    }

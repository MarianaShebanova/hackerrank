import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = Integer.parseInt(sc.nextLine());
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        for (int t = 0; t < tests; t++) {
            String[] op = sc.nextLine().split(" ");
            switch(op[0]) {
                case "1":
                    stack.push(current.toString());
                    current.append(op[1]);
                    break;
                case "2":
                    stack.push(current.toString());
                    String temp = current.substring(0, current.length() - Integer.parseInt(op[1]));
                    current.setLength(0);
                    current.append(temp);
                    break;                
                case "3":
                    System.out.println(current.charAt(Integer.parseInt(op[1]) - 1));
                    break;
                case "4":
                    current.setLength(0);
                    current.append(stack.pop());
                    break;
            }
        } 
        sc.close();
    }
}

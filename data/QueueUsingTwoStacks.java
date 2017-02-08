import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingTwoStacks {

    private static void move(Stack<String> from, Stack<String> to) {
        if (to.isEmpty()) {
            while (!from.isEmpty()) {
                to.push(from.pop());
            }  
        }        
    }
    
    public static void main(String[] args) {
        Stack<String> head = new Stack<>();
        Stack<String> tail = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int query = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < query; i++) {
            String[] op = sc.nextLine().split(" ");
            switch(op[0]) {
                case "1":
                    tail.push(op[1]);
                    break;
                case "2":
                    move(tail, head);
                    if (!head.isEmpty()) {
                        head.pop();
                    }
                    break;
                case "3":
                    move(tail, head);
                    System.out.println(head.peek());
                    break;
            }
        }
        sc.close();
    }
}

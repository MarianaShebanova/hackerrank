import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KindergartenAdventures {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        int max = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int count = t[i] == 0 ? 1 : 0;
            for (int j = (i + 1) % t.length, cur = 1; j != i; j = (j + 1) % t.length, cur++) {
                if (t[j] <= cur) {
                    count++;
                }
            }
            if (maxCount < count) {
                maxCount = count;
                max = i;
            }
        }
        System.out.println(max + 1);
        sc.close();
    }
}

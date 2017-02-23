import java.io.*;
import java.util.*;
import java.math.*;

public class EasySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = n / m;
            int l = n % m;
            System.out.println((long)(m - 1) * m / 2 * k + (long)(l + 1) * l / 2);
        }
        sc.close();
    }
}

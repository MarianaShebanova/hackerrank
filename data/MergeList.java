import java.io.*;
import java.util.*;

public class MergeList {

    private static final int MOD = 1000000007;
    private static final int MAX = 201;
    private static final int[][] binomialCoeff;
    
    static {
        binomialCoeff = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    binomialCoeff[i][j] = 1;
                } else {
                    binomialCoeff[i][j] = (binomialCoeff[i - 1][j - 1] + binomialCoeff[i - 1][j]) % MOD;
                }
            }
        }
    }    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(binomialCoeff[n + m][n]);
        }   
        sc.close();
    }
}

import java.io.*;
import java.util.*;

public class LeonardosPrimeFactors {

    private static final int MAX = 100000;
    private static final long MIN = 614889782588491410L;
    
    private static boolean[] getPrimes() {
        boolean[] primes = new boolean[MAX];
        primes[0] = true;
        primes[1] = true;
        for (int i = 0; i < MAX; i++) {
            if (!primes[i] && (long) i * i < MAX) {
                for (int j = i * i; j < MAX; j += i) {
                    primes[j] = true;
                }
            }
        }
        return primes;
    }
    public static void main(String[] args) {
        boolean[] primes = getPrimes();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            long n = sc.nextLong();
            int j = 0;
            long p = 1;
            int count = 0;
            while (p < Math.min(n, MIN)) {
                if (!primes[j]) {
                    p = p * j;
                    if (p <= n) {
                        count++;
                    }
                }
                j++;
            }
            System.out.println(count);
        }
        sc.close();
    }
}

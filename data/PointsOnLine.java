import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PointsOnLine {

    private static final String YES = "YES";
    private static final String NO = "NO";
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean horizontal = true;
        boolean vertical = true;
        int x = in.nextInt();
        int y = in.nextInt();
        for(int i = 1; i < n; i++){
            int currentX = in.nextInt();
            int currentY = in.nextInt();
            if (x != currentX) {
                horizontal = false;
            }
            if (y != currentY) {
                vertical = false;
            }
        }
        System.out.println(vertical || horizontal ? YES : NO);
        in.close();
    }
}

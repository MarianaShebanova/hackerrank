import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private int heapSize;
    private int[] heap;
    
    Solution(int size) {
        heap = new int[size];
    }
    
    public int getParent(int n) {
        if (n == 0) {
            return -1;
        }        
        return n / 2;
    }
    
    public int getChild(int n) {
        return 2 * n;
    }
    
    public void insert(int data) {
        if (heapSize == heap.length) {
            throw new IllegalStateException("Heap is full");
        }        
        heap[heapSize] = data;
        bubbleUp(heapSize);
        heapSize++;
    }
    
    private void bubbleUp(int p) {
        int parent = getParent(p);
        if (parent == -1) {
            return;
        }
        if (heap[parent] > heap[p]) {
            swap(parent, p);
            bubbleUp(parent);
        }
    }
    
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public void remove(int number) {
        if (heapSize == 0) {
            throw new IllegalStateException("Heap is empty");
        }        
        for (int i = 0; i < heapSize; i++) {
            if (heap[i] == number) {
                heap[i] = heap[heapSize - 1];
                heapSize--;
                bubbleDown(i);
                break;
            }
        }        
    }
    
    private void bubbleDown(int p) {
        int c = getChild(p);
        int minIndex = p;
        for (int i = 0; i <= 1; i++) {
            if (c + i < heapSize) {
                if (heap[minIndex] > heap[c + i]) {
                    minIndex = c + i;
                }
            }
        }
        if (minIndex != p) {
            swap(p, minIndex);
            bubbleDown(minIndex);
        }
    }
    
    private int getMin() {
        return heap[0];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution sol = new Solution(q);
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            switch(t) {
                case 1:
                   sol.insert(sc.nextInt());
                   break;
                case 2:
                   sol.remove(sc.nextInt());
                   break;
                case 3:
                   System.out.println(sol.getMin());
                   break;
            }
        }
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static abstract class Heap {
		private int[] heap;
		private int heapSize;

		Heap(int size) {
			heap = new int[size];
		}

		public void insert(int data) {
			if (heapSize == heap.length) {
				throw new IllegalStateException("Heap is full");
			}
			heap[heapSize] = data;
			bubbleUp(heapSize);
			heapSize++;
		}

		protected abstract boolean compareHeap(int a, int b);

		private void bubbleUp(int p) {
			int parent = getParent(p);
			if (parent == -1) {
				return;
			}
			if (compareHeap(heap[parent], heap[p])) {
				swap(parent, p);
				bubbleUp(parent);
			}
		}

		private void swap(int a, int b) {
			int temp = heap[a];
			heap[a] = heap[b];
			heap[b] = temp;
		}

		private int getParent(int p) {
			if (p == 0) {
				return -1;
			}
			return p / 2;
		}

		public int getHeap() {
			return heap[0];
		}

		public void print() {
			System.out.println(Arrays.toString(heap));
		}

		public int getSize() {
			return heapSize;
		}

		public void remove() {
			if (heapSize == 0) {
				throw new IllegalStateException("Heap is empty");
			}
			heap[0] = heap[heapSize - 1];
			heapSize--;
			bubbleDown(0);
		}

		private int getChild(int p) {
			return 2 * p;
		}

		private void bubbleDown(int p) {
			int c = getChild(p);
			int index = p;
			for (int i = 0; i <= 1; i++) {
				if (c + i < heapSize) {
					if (compareHeap(heap[index], heap[c + i])) {
						index = c + i;
					}
				}
			}
			if (index != p) {
				swap(index, p);
				bubbleDown(index);
			}
		}
	}

	private static class MinHeap extends Heap {
		MinHeap(int size) {
			super(size);
		}

		@Override
		protected boolean compareHeap(int a, int b) {
			return a > b;
		}
	}

	private static class MaxHeap extends Heap {
		MaxHeap(int size) {
			super(size);
		}

		@Override
		protected boolean compareHeap(int a, int b) {
			return a < b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Heap minHeap = new MinHeap(n);
		Heap maxHeap = new MaxHeap(n);
		for (int i = 0; i < n; i++) {
			int number = sc.nextInt();
			if (minHeap.getSize() == 0 || number > minHeap.getHeap()) {
				minHeap.insert(number);
			} else {
				maxHeap.insert(number);
			}
			while (minHeap.getSize() < maxHeap.getSize()) {
				minHeap.insert(maxHeap.getHeap());
				maxHeap.remove();
			}
			while (minHeap.getSize() - maxHeap.getSize() > 1) {
				maxHeap.insert(minHeap.getHeap());
				minHeap.remove();
			}
			double median = 0;
			if (i % 2 == 1) {
				median = (minHeap.getHeap() + maxHeap.getHeap()) * 0.5;
			} else {
				median = minHeap.getHeap();
			}
			System.out.println(median);
		}
	}
}

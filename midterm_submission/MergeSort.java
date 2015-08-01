
import java.util.*;

/**
 * Data Structures and Algorithm 2014 - Mid Semester Test Question 1: MergeSort
 * 
 * This class implements the merge sort algorithm iteratively by simulating a
 * call stack
 * 
 * You should complete the code in the mergeSortIterative method You should not
 * modify the other parts of this program
 * 
 * @Author:Yue Li
 * @Student ID:1251124
 */

public class MergeSort {

	/**
	 * This is a utility method for mergeing two sorted parts of the array data
	 * into one sorted array pre: The subarrays data[low...middle-1] and
	 * data[middle...high] are both sorted post: the array data[low...high] is
	 * sorted
	 */
	private static void merge(int data[], int low, int middle, int high) {
		int ri = 0;
		int ti = low;
		int di = middle;
		int[] result = new int[high - low + 1];
		while (ti < middle && di <= high) {
			if (data[di] < data[ti]) {
				result[ri++] = data[di++];
			} else {
				result[ri++] = data[ti++];
			}
		}
		while (ti < middle)
			result[ri++] = data[ti++];
		while (di <= high)
			result[ri++] = data[di++];
		for (int i = 0; i < high - low + 1; i++)
			data[low + i] = result[i];
	}

	/**
	 * This method should perform merge sort on the input array data[0..n] This
	 * method should be an iterative (non recursive) method and simulate a call
	 * stack You may use the Stack class from Java.util
	 */
	public static void mergeSortIterative(int data[], int n) {
		// ////////////////////////////////////
		Stack<CallFrame> callStack = new Stack<>();
		callStack.push(new CallFrame(0, n - 1));
		while (!callStack.isEmpty()) {
			CallFrame curr = callStack.peek();
			if (curr.pc == 1) {
				if (curr.left >= curr.right) {
					callStack.pop();
					continue;
				}
				merge(data, curr.left, curr.right, curr.right);
				curr.pc++;
				callStack.push(new CallFrame(curr.left, curr.right - 1));
			} else if (curr.pc == 2) {
				curr.pc++;
				callStack.push(new CallFrame(curr.left + 1, curr.right));
			} else {
				callStack.pop();
				continue;
			}
		}
	}

	/**
	 * The main method for testing the unique queue data structure
	 * 
	 * @author jiamou liu
	 */
	public static void main(String[] args) {

		int[] data = new int[] { 4, 2, 7, 14, 12, 32, 1, 53, 99, 18, 40, 42,
				62, 19, 5, 63, 23, 13, 9, 8, 39, 45 };

		mergeSortIterative(data, data.length);
		//
		for (int i = 0; i < data.length; i++)
			System.out.print(data[i] + " ");
		System.out.println("");

		// Expected outcome:
		// 1 2 4 5 7 8 9 12 13 14 18 19 23 32 39 40 42 45 53 62 63 99
	}
}

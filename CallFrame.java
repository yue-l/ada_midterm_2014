

// The CallFrame class used for simulating a call stack
// You should not modify this program for Question 1
// Author: Jiamou Liu

public class CallFrame{

		public int left;	// The left pointer
		public int right;  	// The right pointer
		public int pc; 		// The program counter

		public CallFrame(int l, int r){
			left = l;
			right = r;
			pc=1;
		}

}


/* Data Structures and Algorithm 2014 - Mid Semester Test
 * Question 3. Non-repetitive Queue
 *
 * This class implements a queue data structure that does not allow duplicated members
 * When enqueueing a value which is already contained in the queue,
 * the data structure first deletes the existing member of the queue with this value, and then
 * reinsert it at the end of the queue
 *
 * @ Author: Yue Li
 * @ Student ID:1251124
 */

public class UniqueQueue<E> implements Queue<E> {

	final int INITIAL_CAPACITY = 5; // The initial capacity of the array

	// This array contains all elements of the queue.
	// You need to make it a circular array
	// private Object[] data;
	Object[] data;

	int size; // The current number of elements
	// private int size; // The current number of elements
	int front; // index of the front of the queue
	// private int front; // index of the front of the queue
	int rear; // index of the tail of queue. This index should point to

	// private int rear; // index of the tail of queue. This index should point
	// to
	// the position where we would add a new element to

	/**
	 * You need to complete the constructor
	 */
	public UniqueQueue() {
		// //////////////////////////////////////
		// Insert your code here
		data = new Object[INITIAL_CAPACITY];
		front = 0;
		rear = size;
		// //////////////////////////////////////
	}

	/**
	 * A utility method for expanding the capacity of the current array The
	 * resulting array will be twice in length
	 */
	private void expandCapacity() {
		// Create a temporary array twice as long as data
		Object[] temp = new Object[data.length * 2];
		// Copy all elements in the queue to temp
		for (int i = 0; i < temp.length; i++) {
			temp[i] = data[(front + i) % data.length];
		}
		// initialize data to twice as long
		data = new Object[data.length * 2];
		// copy all elements back to data
		// After copying, the front of the queue is at index 0, the rear at
		// index size
		for (int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}
		front = 0;
		rear = size;
	}

	/**
	 * Add a value to the tail of the queue. If value is already in the queue,
	 * delete it before re-entering at the tail
	 * 
	 */
	public void enqueue(E value) {
		// Checking if the array has been completely filled
		// by elements of the queue
		// If all positions are taken, then we need to expand the capacity of
		// the array
		// by calling the expandCapacity() method
		if (!(size() < data.length) && size() != 0)
			expandCapacity();
		// //////////////////////////////////////
		// Insert your code here
		int removeIndex = 0;
		boolean isDuplicated = false;
		// check current array
		for (int index = 0; index < size; index++) {
			if (value.equals(data[index])) {
				removeIndex = index;
				isDuplicated = true;
			}
		}
		if (isDuplicated) {
			Object removed = data[removeIndex];
			for (int index = removeIndex; index < size; index++) {
				data[index] = data[index + 1];
			}
			data[rear - 1] = value;
		} else {
			size++;
			data[rear] = value;
		}
		rear = size;
		// //////////////////////////////////////

	}

	/**
	 * Remove a value from the head of the queue.
	 * 
	 */
	public E dequeue() {
		// Checking if the queue is empty
		if (size() <= 0) {
			System.out.println("The queue is empty");
			return null;
		}

		// //////////////////////////////////////
		// Insert your code here
		E value = getFirst();
		for (int i = 0; i < size; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return value;
		// //////////////////////////////////////
	}

	/**
	 * Fetch the value at the head of the queue.
	 * 
	 */
	public E getFirst() {
		// Checking if the queue is empty
		if (size() <= 0) {
			System.out.println("The queue is empty");
			return null;
		}

		// //////////////////////////////////////
		// Insert your code here
		E value = (E) data[0];
		return value;
		// //////////////////////////////////////
	}

	/**
	 * Returns the number of elements in the queue.
	 * 
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if and only if the queue is empty.
	 * 
	 */
	public boolean empty() {
		return size() == 0;
	}

	/**
	 * The main method for testing the unique queue data structure
	 * 
	 * @author jiamou liu
	 */
	public static void main(String[] args) {
		Queue<String> q = new UniqueQueue<String>();
		q.enqueue("Adam");
		q.enqueue("Bob");
		q.enqueue("Charlie");
		q.enqueue("David");
		q.enqueue("Eddy");
		q.enqueue("Graham");
		q.enqueue("Helen");
		q.enqueue("Graham");
		q.enqueue("Eddy");
		q.enqueue("Helen");
		q.enqueue("Yan");
		q.enqueue("Zoe");
		q.enqueue("Zoe");
		q.enqueue("Zoe");
		q.enqueue("Adam");
		q.enqueue("Adam");
		// test starts
		while (!q.empty()) {
			System.out.println("Size: " + q.size() + " Front element: "
					+ (String) q.dequeue());
		}
		System.out.println("");

		// Expected Output:
		// Size: 9 Front element: Bob
		// Size: 8 Front element: Charlie
		// Size: 7 Front element: David
		// Size: 6 Front element: Graham
		// Size: 5 Front element: Eddy
		// Size: 4 Front element: Helen
		// Size: 3 Front element: Yan
		// Size: 2 Front element: Zoe
		// Size: 1 Front element: Adam
	}

}

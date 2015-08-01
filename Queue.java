// Interface for queues.
// (c) 1998,2001 duane a. bailey
// Modified by Jiamou Liu for DSA Mid Semester Test 2014

/**
 * Interface describing a first-in, first-out structure.
 * Values are added at the tail, and removed from the head.
 * Queues are typically used to process values in the order that they appear
 * and to store the state of a buffered object.
 * The structure package provides several implementations of the Queue interface,
 * each of which has its particular strengths and weaknesses.
 */
public interface Queue<E>
{

    /**
     * Add a value to the tail of the queue.
     *
     * @post the value is added to the tail of the structure
     *
     * @param value The value to be added.
     */
    public void enqueue(E value);

    /**
     * Remove a value form the head of the queue.
     *
     * @pre the queue is not empty
     * @post the head of the queue is removed and returned
     *
     * @return The value actually removed.
     * @see #dequeue
     */
    public E dequeue();

    /**
     * Fetch the value at the head of the queue.
     *
     * @pre the queue is not empty
     * @post the element at the head of the queue is returned
     *
     * @return Reference to the first value of the queue.
     */
    public E getFirst();


    /**
     * Returns true iff the queue is empty.  Provided for
     * compatibility with java.util.Vector.empty.
     *
     * @post returns true if and only if the queue is empty
     *
     * @return True iff the queue is empty.
     */
    public boolean empty();

    /**
     * Returns the number of elements in the queue.
     *
     * @post returns the number of elements in the queue
     * @return number of elements in queue.
     */
    public int size();
}

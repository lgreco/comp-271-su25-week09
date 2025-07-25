/**
 * The {@code Xifo} interface defines a generic contract for data structures that
 * follow an abstract \"extended input/output\" discipline—such as queues, stacks,
 * or hybrids thereof—where elements are processed in a specific order.
 * <p>
 * Implementing classes must provide mechanisms to preview, remove, and display
 * elements from the underlying data structure.
 *
 * @param <E> the type of elements held in this Xifo structure
 *
 * <p>Typical usage might include FIFO (queue), LIFO (stack), or priority-based
 * implementations, depending on the semantics of {@code pop()} and {@code peek()}.
 */
public interface Xifo<E> {
    
    /**
     * Returns (without removing) the front element of the underlying data structure.
     * This provides a \"sneak preview\" of the next element to be removed.
     *
     * @return the element at the front of the structure, or {@code null} if empty
     */
    E peek();

    /**
     * Removes and returns the front element of the underlying data structure.
     * After removal, the structure should be updated so the next element in line
     * becomes the new front.
     *
     * @return the element that was at the front of the structure, or {@code null} if empty
     */
    E pop();

    /**
     * Returns a string representation of the implementing object. This typically includes
     * details about the current contents or state of the structure.
     *
     * @return a string describing the contents or configuration of this structure
     */
    @Override
    String toString();
}
// interface Xifo
/**
 * The {@code Fifo} interface defines the contract for First-In-First-Out (FIFO)
 * data structures, such as queues. In these structures, elements are added at
 * the rear and removed from the front, preserving the order of insertion.
 *
 * <p>
 * Implementing classes must provide a method for adding elements to the structure,
 * typically at the end (or rear), based on the current number of elements.
 *
 * @param <E> the type of elements stored in this FIFO structure
 */
public interface Fifo<E> {

    /**
     * Adds the specified element to the first available position at the rear of
     * the underlying data structure. The exact location is usually determined
     * by the number of elements currently stored.
     *
     * @param e the element to be added to the structure
     */
    void add(E e);
}
// interface Fifo
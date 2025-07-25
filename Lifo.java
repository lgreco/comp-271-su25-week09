/**
 * The {@code Lifo} interface defines the contract for Last-In-First-Out (LIFO)
 * data structures, such as stacks. In such structures, the most recently added
 * element is the first to be removed.
 *
 * <p>
 * Implementing classes must define how elements are added (pushed) to the front
 * of the structure, typically requiring a shift of existing elements to maintain
 * order.
 *
 * @param <E> the type of elements stored in this LIFO structure
 */
public interface Lifo<E> {

    /**
     * Inserts the specified element at the front of the underlying data structure.
     * In a LIFO implementation, this operation may involve shifting existing elements
     * to the right to accommodate the new item at the front.
     *
     * @param e the element to be added to the structure
     */
    void push(E e);
}
 // interface Lifo
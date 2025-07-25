public class solution_Queue extends DynamicArray implements Comparable<solution_Queue>, Xifo<String>, Fifo<String> {

    public int compareTo(solution_Queue other) {
        return this.getOccupancy()-other.getOccupancy();
    } // method compareTo

    public String peek() {
        return this.getFirst();
    } // method peek

    public String pop() {
        return this.remove(0);
    } // method pop

    public String toString() {
        return this.toString();
    } // method toString

} // class Queue
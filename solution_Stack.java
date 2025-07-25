public class solution_Stack extends DynamicArray implements Comparable<solution_Stack>, Xifo<String>, Lifo<String> {

    public int compareTo(solution_Stack other) {
        return this.getOccupancy() - other.getOccupancy();
    }

    public String peek() {
        return this.getFirst();
    }

    public String pop() {
        return this.remove(0);
    }

    public String toString() {
        return this.toString();
    }

    public void push(String e) {
        this.add(e, 0);
    }

}
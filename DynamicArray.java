/**
 * Object adjusts the size of underlying array to accommodate any number of new
 * elements added to it. The class is written as generic.
 */
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    /** The underlying array of the data structure */
    private String[] underlying;
    /** How many elements have been added to the underlying array */
    private int occupancy;

    /** Basic constructor */
    public DynamicArray(int size) {
        // Guard statement here to ensure that the user-provided size is legit.
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        // Create an Object array of the requested size, then cast it
        // as an array of objects E
        this.underlying = new String[size];
        // At the beginning the underlying array is empty
        this.occupancy = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /** Simple accessor for occupancy */
    public int getOccupancy() {
        return this.occupancy;
    } // method getOccupancy

    /** Getter exposing the first element of underlying array */
    public String getFirst() {
        return this.underlying[0];
    }

    /**
     * Resize the underlying array as needed.
     * 
     * @param resize_by int factor multiply the size of the underlying array
     */
    private void resize() {
        // Create temporary array of DOUBLE the size of the underlying array
        String[] temp = new String[2 * this.underlying.length];
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    } // method resize

    /**
     * Adds a new item to the array. Method checks if array needs to be resized
     * first (when at capacity, meaning occupancy = array length).
     * 
     * @param string String to add to underlying array
     */
    public void add(String string) {
        // Is there room in the underlying array?
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        // At this point there is guaranteed room in the array, either
        // because we just doubled it in size or because there was enough
        // room for one more element to begin with.
        this.underlying[this.occupancy] = string;
        this.occupancy++;
    } // method add

    /**
     * As a string to a specific position, first moving everyting to the right of
     * that position one place to the right.
     */
    public void add(String e, int position) {
        // Is there room for one more element?
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        // Move everything to the right of the target position one place to the right.
        // Since we are shifting to the right, it's important to traverse the array
        // elements from right to left to avoid duplications.
        for (int i = this.occupancy; i >= position; i++) {
            this.underlying[i] = this.underlying[i-1];
        }
        // Position clear to overwrite
        this.underlying[position] = e;
        // update occupancy
        this.occupancy++;
    }

    /**
     * method to find the position of an element in the underlying array
     * 
     * @return -1 if string not present, otherwise underlying array position of
     *         first occurrence of string.
     */
    public int indexOf(String string) {
        // Start searching from the beginning of the underlying array.
        int i = 0;
        // Keep searching until we process all the positions used in the array
        // (indicated by this.occupancy) without finding the target string or as soon as
        // we find it.
        while (i < this.occupancy && !this.underlying[i].equals(string)) {
            i++;
        }
        // Using the ternary operator is always cool!
        return (i == this.occupancy) ? -1 : i;
    } // method indexOf

    /** Method to tell if a string exists in the underlying array */
    public boolean contains(String string) {
        return this.indexOf(string) > -1; // != -1 ok too
    } // method contains

    /** Method to count how many times a string appears in the underlying array */
    public int countOf(String string) {
        int counter = 0;
        if (string != null) {
            for (int i = 0; i < this.occupancy; i++) {
                if (string.equals(this.underlying[i])) {
                    counter += 1;
                }
            }
        }
        return counter;
    } // method countOf

    /**
     * Method to remove an item from the underlying array based on its index
     * position and return it.
     * 
     * @param index int position of element to remove
     * @return String removed from array; null if position is not wihtin used range
     *         of the underlying array.
     */
    public String remove(int index) {
        // Initialize the return item
        String removed = null;
        // Guard statement to ensure that array is not empty, and that removal index
        // references a used position within the underlying array
        if (this.occupancy > 0 && index > -1 && index < this.occupancy) {
            // Obtain the removed item
            removed = this.underlying[index];
            // Shift everyting to the right of the removed item, one position to the left.
            for (int i = index; i < this.occupancy - 1; i++) {
                this.underlying[i] = this.underlying[i + 1];
            }
            // Place a null to avoid duplicate elements at the end of the shifted block.
            this.underlying[this.occupancy - 1] = null;
            // Decrease the occupancy of the underlying array.
            this.occupancy -= 1;
        }
        // Done
        return removed;
    } // method remove

    /**
     * Overload remove method that removes the first occurence of a given string.
     * This method wraps around remove(int), leveraging the output of
     * indexOf(String). If the string is not present, indexOf returns -1. This is an
     * illegal index position for remove(int) and it will return null in this case.
     * 
     * @param string String to search for remove first occurence
     * @return String removed or null of given string not present in underlying
     *         array
     */
    public String remove(String string) {
        return this.remove(this.indexOf(string));
    } // method remove

    // Constants to be used in toString
    private static final String EMPTY_ARRAY = "The underlying array is empty.";
    private static final String FMT_HEADER = "Underlying array occupancy/length: %d/%d.\n[ %s";
    private static final String FMT_ELEMENT = ", %s";
    private static final String FMT_FOOTER = " ]";

    /**
     * String representation of the object. The method uses a StringBuilder object
     * to demonstrate its versatility. But it can be implemented with plain strings.
     * 
     * @return String representing the object and the contents of the underlying
     *         array; if array is empty, an appropriate message is returned.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder(EMPTY_ARRAY);
        if (this.occupancy > 0) {
            sb = new StringBuilder(
                    String.format(FMT_HEADER, this.occupancy, this.underlying.length, this.underlying[0]));
            for (int i = 1; i < this.occupancy; i++) {
                sb.append(String.format(FMT_ELEMENT, this.underlying[i]));
            }
            sb.append(FMT_FOOTER);
        }
        return sb.toString();
    } // method toString

} // class DynamicArray
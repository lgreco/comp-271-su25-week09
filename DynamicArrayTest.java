/* Naive testing -- this can be generated with an AI tool. Real testing 
requires junit stuff and by default these imports are not in the project's 
classpath. Adding them to a pom file may be beyond the scope of the course 
for now. */

class DynamicArrayTest {

    public static void main(String[] args) {
        testAddAndResize();
        testIndexOf();
        testContains();
        testCountOf();
        testRemoveByIndex();
        testRemoveByValue();
        testToStringEmpty();
        testToStringNonEmpty();
        System.out.println("All tests finished.");
    }

    static void assertEquals(String testName, Object expected, Object actual) {
        if ((expected == null && actual == null) || (expected != null && expected.equals(actual))) {
            System.out.println("✅ " + testName + " passed.");
        } else {
            System.out.println("❌ " + testName + " failed. Expected: " + expected + ", but got: " + actual);
        }
    }

    static void assertTrue(String testName, boolean condition) {
        if (condition) {
            System.out.println("✅ " + testName + " passed.");
        } else {
            System.out.println("❌ " + testName + " failed.");
        }
    }

    static void testAddAndResize() {
        DynamicArray a = new DynamicArray(2);
        a.add("one");
        a.add("two");
        a.add("three"); // should trigger resize
        assertEquals("Add and Resize: occupancy", 3, a.getOccupancy());
        assertEquals("Add and Resize: indexOf(three)", 2, a.indexOf("three"));
    }

    static void testIndexOf() {
        DynamicArray a = new DynamicArray();
        a.add("a");
        a.add("b");
        a.add("c");
        assertEquals("IndexOf: b", 1, a.indexOf("b"));
        assertEquals("IndexOf: z", -1, a.indexOf("z"));
    }

    static void testContains() {
        DynamicArray a = new DynamicArray();
        a.add("foo");
        a.add("bar");
        assertTrue("Contains: foo", a.contains("foo"));
        assertTrue("Contains: baz", !a.contains("baz"));
    }

    static void testCountOf() {
        DynamicArray a = new DynamicArray();
        a.add("x");
        a.add("y");
        a.add("x");
        a.add("z");
        a.add("x");
        assertEquals("CountOf: x", 3, a.countOf("x"));
        assertEquals("CountOf: not-there", 0, a.countOf("not-there"));
    }

    static void testRemoveByIndex() {
        DynamicArray a = new DynamicArray();
        a.add("a");
        a.add("b");
        a.add("c");
        assertEquals("Remove by index: 1", "b", a.remove(1));
        assertEquals("Occupancy after removal", 2, a.getOccupancy());
        assertEquals("Remove by index: out of bounds", null, a.remove(5));
    }

    static void testRemoveByValue() {
        DynamicArray a = new DynamicArray();
        a.add("alpha");
        a.add("beta");
        a.add("gamma");
        assertEquals("Remove by value: beta", "beta", a.remove("beta"));
        assertEquals("Remove by value: delta", null, a.remove("delta"));
        assertTrue("Value no longer present", !a.contains("beta"));
    }

    static void testToStringEmpty() {
        DynamicArray a = new DynamicArray();
        String result = a.toString();
        assertTrue("ToString empty check", result.contains("empty"));
    }

    static void testToStringNonEmpty() {
        DynamicArray a = new DynamicArray();
        a.add("hello");
        a.add("world");
        String str = a.toString();
        assertTrue("ToString contains hello", str.contains("hello"));
        assertTrue("ToString contains world", str.contains("world"));
        assertTrue("ToString has occupancy info", str.contains("occupancy"));
    }
}

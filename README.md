# COMP 271 SU25 WEEK 09

This assignment has two parts: a coding part based on current material we discuss in class and a reflection part to evaluate work you have already submitted.


## Standing requirements

* **Programmers Pact:** Your work must be compliant with the [Programmers Pact](./ProgrammerPact.pdf). 
* **Comments:** Your code must be sufficiently documented with comments.
* **No imports:** You may not use the import statement in your code, with one exception: `import Arrays;` is allowed only for using `Arrays.toString()`. No other methods of class `Arrays` may be used.
* **Only `System.out` calls:** you may use `System.out` to print to the console. No other methods from `System` are allowed. Only `System.out.println`, `System.out.printf`, and `System.out.print`. 


## Finals week policy

There is no final exam for the course. There will be a final assignemnt that will be published the week before finals and will be due the week of finals. Additionally, 8 students in the course will be [invited randomly](https://github.com/lgreco/random-selection-final-oral) to a brief meeting with the instructor during the course's final exam slot. The final exam slot for this course is on Tuesday, August 5, 2025 from 9 to 11 AM. If you are selected for a brief meeting, we'll spend about 15 minutes during the final exam slot to review your work. This interview will cover coding practices based on your past assignments. It is meant as a checkpoint to ensure that you have internalized the work you submitted.

---

## Code

This assignment is meant to reinforce your understanding of recursion in Java by designing and implementing recursive solutions to classic problems. First please review and understand the [implementation of **MergeSort** using recursion](./Merge.java).

In addition to the standing coding requirements above, your code for this assignment should be implemented using recursion **only**. Do **not** use loops (`for`, `while`, etc.), helper libraries that use iteration, or mutable static/global variables.

### Part 1: Recursive Maximum Finder

```java
public static int findMax(int[] arr, int left, int right)
```

**Description:**  
Given an integer array and two indices (`left` and `right`), recursively find and return the **maximum element** in the subarray from `arr[left]` to `arr[right]` inclusive.

**Hint:** This is conceptually similar to how MergeSort divides arrays.


---

### Part 2: Recursive Array Reversal

```java
public static void reverseArray(int[] arr, int left, int right)
```

**Description:** Recursively reverse the elements of the array **in-place**, swapping elements between `left` and `right`.

---

### Part 3: Count Occurrences of a Value

```java
public static int countOccurrences(int[] arr, int target, int index)
```

**Description:** Recursively count how many times `target` appears in `arr[index]` to the end of the array.

---

### Part 4: Recursive Binary Search

```java
public static int binarySearch(int[] arr, int target, int left, int right)
```

**Description:** Use the recursive binary search approach to find the index of `target` in a **sorted** array. Return `-1` if the element is not found.

---

## Submission Guidelines:

- Submit a single Java file named `RecursiveExercises.java`.
- Each method should be **self-contained**, **recursive**, and **well-documented**.
- Include a `main()` method to demonstrate test cases that **you write** for each task.

---

## Study

From the BJP textbook Chapter 12; or [Ch. 5 from Collins’ book](https://learning.oreilly.com/library/view/data-structures-and/9780470482674/12-chapter05.html).

---

## Reflect

Compare your code from the previous assignment with [Leo's posted solutions](./DynamicArray.java).

Then write a brief reflection (100-300 words) discussing what you got right, what you got close but not quite, and where you may have missed the mark. Also discuss what you learned by comparing your code to the posted solutions. The reflection must be substantive. For example, you may find that you missed something in the assignment because you did not put enough time in it or because you did not start work early. It's fine to acknowledge these issues. It is also important to propose a plan to avoid them in the future. And, in later reflections, evaluate how that plan worked.


### TECHNICAL NOTES FOR UNGRADING


#### `void add(String)`
The method must first check if there is room for one more element in the object. If not, the underlying array must be resized with `private resize()` first. Don't forget to increment the `occupancy` after the addition of the new element.

#### `int indexOf(String)`
Check for violations of the Pact, and specifically: multiple `return` statements (even two is one too many), or a `break` statement in a loop. Also it's important to check the elements up to and not including `this.occupancy`. Anything past this position should be `null`.

#### `boolean contains(String)`
This is practically a wrapper for `indexOf`. If the string is present of the array, its `indexOf` will be > -1. There should be no additional code here, other than a call to `indexOf`.

#### `int countOf(String)`
This requires a `for`-loop to check every used position in the underlying array. The loop should run up to (but not including) `this.occupancy`.

#### `String remove(int)`
The method should make sure that the provided index value is legitimate. The method should also shift the elements to the right of the removed element, one position to the right.

#### `String remove(String)`
This should be a wrapper to `remove(int)`, with no other code in it.

#### `String toString()`
It's ok if you didn't use `StringBuilder`. But is your output neat looking?


#### Does your code compile? 
If not, the assignment is incomplete. If your assignment is incomplete you must make an appointment to speak with Leo, as soon as possible.


#### Did your code pass the tests?
If not, the assignment is incomplete. If your assignment is incomplete you must make an appointment to speak with Leo, as soon as possible.


#### Incomplete code

If your code is incomplete for any of the reasons above, please reflect on the cause. Did you start late? Did you hit a roadblock but did not ask for help? Did you not read the Programmer's Pact? Something else?


#### Are there any Pact violations?
You should always check your code versus the Programmer's Pact and verify that you have not violated any of its stipulations.


#### How to submit

Your reflection should be submitted together with the current homework assignment due 6/25. Write your reflection as a *markdown* file called `reflection.md` in the current assignment's repository. **MarkDown** is a fairly simple markup (I know!) language that's worth learning. You can use a [simple cheat sheet](https://www.markdownguide.org/basic-syntax/) for MarkDown (.md) files or you can look at the course code of any `.md` file I share with you such as this one here. You can open any `.md` file on your CodeSpaces editor to see how it's written. 

If MarkDown is not your cup of tea that's ok too. Write your reflection in an email and send it to me with the header "reflection" in the subject line. But if you see yourself as a programmer/computer scientist down the road, it's worth the time to learn to write in MarkDown.

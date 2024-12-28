# Squaring a sorted array (easy)
## Problem statement
Given a sorted array of integers, both negative and positive, create a new array containing the squares
of each number which should also be sorted in non-decreasing order.

## Example
```kotlin
val nums = intArrayOf(-4, -1, 0, 3, 10)
val result = intArrayOf(0, 1, 9, 16, 100)
```

## Approaches
1. Brute force approach
2. Optimal approach using two pointers

### 1. Brute force approach
#### Algo
1. Iterate through the array, calculate the square for each number by multiplying `nums[i]` with itself.
2. Sort the out-coming list of squares in non-decreasing order.

```kotlin
package TwoPointers.SquaringASortedArray

fun squareSortedArrayBruteForce(nums: IntArray): IntArray {
    return nums.map {
        it * it
    }.sorted().toIntArray()
}

fun main() {
    // Test case 1: Mixed positive and negative numbers
    println(squareSortedArrayBruteForce(intArrayOf(-4, -1, 0, 3, 10)).contentToString())
    // Output: [0, 1, 9, 16, 100]

    // Test case 2: All negative numbers
    println(squareSortedArrayBruteForce(intArrayOf(-7, -3, -2, -1)).contentToString())
    // Output: [1, 4, 9, 49]

    // Test case 3: All positive numbers
    println(squareSortedArrayBruteForce(intArrayOf(0, 2, 3, 10)).contentToString())
    // Output: [0, 4, 9, 100]

    // Test case 4: Single element (positive)
    println(squareSortedArrayBruteForce(intArrayOf(5)).contentToString())
    // Output: [25]

    // Test case 5: Single element (negative)
    println(squareSortedArrayBruteForce(intArrayOf(-5)).contentToString())
    // Output: [25]

    // Test case 6: Empty array
    println(squareSortedArrayBruteForce(intArrayOf()).contentToString())
    // Output: []

    // Test case 7: Large numbers
    println(squareSortedArrayBruteForce(intArrayOf(-10000, -500, 0, 500, 10000)).contentToString())
    // Output: [0, 250000, 250000, 100000000, 100000000]

    // Test case 8: Array with all zeros
    println(squareSortedArrayBruteForce(intArrayOf(0, 0, 0)).contentToString())
    // Output: [0, 0, 0]

    // Test case 9: Mixed negatives and positives close to zero
    println(squareSortedArrayBruteForce(intArrayOf(-2, -1, 0, 1, 2)).contentToString())
    // Output: [0, 1, 1, 4, 4]

    // Test case 10: Array with duplicates
    println(squareSortedArrayBruteForce(intArrayOf(-3, -3, -1, 2, 2, 3)).contentToString())
    // Output: [1, 4, 4, 9, 9, 9]
}
```

#### Time complexity
- Time complexity for squaring each element is `O(n)`.
- Time complexity for sorting would be `O(n.logn)`.
- Total time complexity is `O(n.logn)`.

#### Space complexity
- `O(n)` for storing the squared numbers.

### 2. Optimal approach using two pointers
#### Algo
1. Maintain `left`, `right` and `index` pointers.
    - `left` initialises to 0. Keeps track of the numbers being squared from the left side and stored into the `result` array.
    - `right` initialised to `nums.size - 1`. Keeps track of the numbers being squared from the right side and stored into the `result` array.
    - `index` initialised to `nums.size - 1`. Keeps pointing to the next index where the next squared value should go into in the `result` array.
2. Maintain the `result` array that we return.
3. Until `left <= right`
    - Calculate `leftSquare` and `rightSquare`. 
    - If `leftSquare > rightSquare`, means that the left element must be bigger negative number in absolute terms and square of it
   is bigger than the rightmost element. In this case, add the `leftSquare` to `result[index]` and increment `left`. Also decrement
   `index`.
    - If `rightSquare >= leftSquare`, means that the right element has a bigger square, add `rightSquare` at `result[index]`. Decrement 
   `right` and `index`.

#### Code
```kotlin
package TwoPointers.SquaringASortedArray

fun squareSortedArrayTwoPointers(nums: IntArray): IntArray {
    val n = nums.size
    var left = 0
    var right = n - 1
    var index = n - 1
    var result = IntArray(n)

    /**
     * Since the array can have negative integers, either the `leftSquare` or `rightSquare` can be the biggest number. To address this,
     * we introduce two pointers at `left` and `right`.
     *
     * Based on whether `leftSquare` is bigger than `rightSquare` or not, we push the square value in the result array from end. If
     * `leftSquare` is bigger than `rightSquare`, increment `left`, else decrement `right`. Keep decrementing the `index` pointer in each
     * iteration.
     */
    while (left <= right) {
        val leftSquare = nums[left] * nums[left]
        val rightSquare = nums[right] * nums[right]

        if (leftSquare > rightSquare) {
            result[index] = leftSquare
            left++
        } else {
            result[index] = rightSquare
            right --
        }
        index--
    }

    return result
}

fun main() {
    // Test case 1: Mixed positive and negative numbers
    println(squareSortedArrayTwoPointers(intArrayOf(-4, -1, 0, 3, 10)).contentToString())
    // Output: [0, 1, 9, 16, 100]

    // Test case 2: All negative numbers
    println(squareSortedArrayTwoPointers(intArrayOf(-7, -3, -2, -1)).contentToString())
    // Output: [1, 4, 9, 49]

    // Test case 3: All positive numbers
    println(squareSortedArrayTwoPointers(intArrayOf(0, 2, 3, 10)).contentToString())
    // Output: [0, 4, 9, 100]

    // Test case 4: Single element (positive)
    println(squareSortedArrayTwoPointers(intArrayOf(5)).contentToString())
    // Output: [25]

    // Test case 5: Single element (negative)
    println(squareSortedArrayTwoPointers(intArrayOf(-5)).contentToString())
    // Output: [25]

    // Test case 6: Empty array
    println(squareSortedArrayTwoPointers(intArrayOf()).contentToString())
    // Output: []

    // Test case 7: Large numbers
    println(squareSortedArrayTwoPointers(intArrayOf(-10000, -500, 0, 500, 10000)).contentToString())
    // Output: [0, 250000, 250000, 100000000, 100000000]

    // Test case 8: Array with all zeros
    println(squareSortedArrayTwoPointers(intArrayOf(0, 0, 0)).contentToString())
    // Output: [0, 0, 0]

    // Test case 9: Mixed negatives and positives close to zero
    println(squareSortedArrayTwoPointers(intArrayOf(-2, -1, 0, 1, 2)).contentToString())
    // Output: [0, 1, 1, 4, 4]

    // Test case 10: Array with duplicates
    println(squareSortedArrayTwoPointers(intArrayOf(-3, -3, -1, 2, 2, 3)).contentToString())
    // Output: [1, 4, 4, 9, 9, 9]
}
```

#### Time complexity
- Each element is processed only once, so `O(n)`.

#### Space complexity
- `O(n)` for storing the result array.
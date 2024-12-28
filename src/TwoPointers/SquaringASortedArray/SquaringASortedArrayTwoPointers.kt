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

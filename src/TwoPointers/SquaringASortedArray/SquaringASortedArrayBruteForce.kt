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

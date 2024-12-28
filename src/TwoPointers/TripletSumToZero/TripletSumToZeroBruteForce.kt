package TwoPointers.TripletSumToZero

fun tripletSumToZeroBruteForce(nums: IntArray): List<List<Int>> {
    // We use Set here to avoid duplicates being added.
    val result = mutableSetOf<List<Int>>()

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            for (k in j + 1 until nums.size) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(listOf(nums[i], nums[j], nums[k]).sorted())
                }
            }
        }
    }

    return result.toList()
}

fun main() {
    // Test Case 1: Mixed positives and negatives
    println(tripletSumToZeroBruteForce(intArrayOf(-3, 0, 1, 2, -1, 1, -2)))
    // Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]

    // Test Case 2: All negatives
    println(tripletSumToZeroBruteForce(intArrayOf(-5, -4, -3, -2, -1)))
    // Output: []

    // Test Case 3: All positives
    println(tripletSumToZeroBruteForce(intArrayOf(1, 2, 3, 4, 5)))
    // Output: []

    // Test Case 4: Contains zeros
    println(tripletSumToZeroBruteForce(intArrayOf(0, 0, 0, 0)))
    // Output: [[0, 0, 0]]

    // Test Case 5: Large array with duplicates
    println(tripletSumToZeroBruteForce(intArrayOf(-3, -3, 1, 2, 2, 0, -2, 1, -1)))
    // Output: [[-3, 1, 2], [-2, 0, 2], [-1, 0, 1]]

    // Test Case 6: Empty array
    println(tripletSumToZeroBruteForce(intArrayOf()))
    // Output: []

    // Test Case 7: Single element
    println(tripletSumToZeroBruteForce(intArrayOf(0)))
    // Output: []

    // Test Case 8: Two elements
    println(tripletSumToZeroBruteForce(intArrayOf(0, 1)))
    // Output: []
}

package TwoPointers.TripletSumToZero

fun tripletSumToZeroOptimal(nums: IntArray): List<List<Int>> {
    nums.sort() // sort the incoming array
    val result = mutableSetOf<List<Int>>()

    for (i in nums.indices) {
        var start = i+1
        var end = nums.size - 1

        // This is basically target sum problem now with target sum as the current number in the iteration.
        while (start < end) {
            val currentSum = nums[start] + nums[end]
            if (currentSum == -nums[i]) { // if current sum is the exact negative of nums[i], that means their sum would be 0
                result.add(listOf(nums[i], nums[start], nums[end]))
                start++
                end--
            } else if (currentSum < -nums[i]) { // meaning the sum is less than 0
                start++
            } else { // meaning the sum is greater than 0
                end--
            }

            // Alternative approach of calculating the current sum as per ChatGPT
//            if (currentSum == 0) {
//                result.add(listOf(i, start, end))
//                start++
//                end--
//            } else if (currentSum < 0) {
//                start++
//            } else {
//                end--
//            }
        }
    }

    return result.toList()
}

fun main() {
    // Test Case 1: Mixed positives and negatives
    println(tripletSumToZeroOptimal(intArrayOf(-3, 0, 1, 2, -1, 1, -2)))
    // Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]

    // Test Case 2: All negatives
    println(tripletSumToZeroOptimal(intArrayOf(-5, -4, -3, -2, -1)))
    // Output: []

    // Test Case 3: All positives
    println(tripletSumToZeroOptimal(intArrayOf(1, 2, 3, 4, 5)))
    // Output: []

    // Test Case 4: Contains zeros
    println(tripletSumToZeroOptimal(intArrayOf(0, 0, 0, 0)))
    // Output: [[0, 0, 0]]

    // Test Case 5: Large array with duplicates
    println(tripletSumToZeroOptimal(intArrayOf(-3, -3, 1, 2, 2, 0, -2, 1, -1)))
    // Output: [[-3, 1, 2], [-2, 0, 2], [-1, 0, 1]]

    // Test Case 6: Empty array
    println(tripletSumToZeroOptimal(intArrayOf()))
    // Output: []

    // Test Case 7: Single element
    println(tripletSumToZeroOptimal(intArrayOf(0)))
    // Output: []

    // Test Case 8: Two elements
    println(tripletSumToZeroOptimal(intArrayOf(0, 1)))
    // Output: []
}

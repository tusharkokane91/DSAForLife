package SlidingWindow.LongestSubarrayWithOnesAfterReplacement

fun longestSubarrayWithOnesAfterReplacementBruteForce(nums: IntArray, k: Int): Int {
    var maxLength = 0

    for (start in nums.indices) {
        var zeroCount = 0
        for (end in start until nums.size) {
            if (nums[end] == 0) zeroCount++
            if (zeroCount > k) {
                continue
            } else {
                maxLength = maxOf(maxLength, end-start+1)
            }
        }
    }

    return maxLength
}

fun main() {
    // Test Case 1: Basic Test Case
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(1, 0, 1, 1, 0, 1, 0, 1, 1), 2))  // Expected: 7

    // Test Case 2: All Ones, No Replacement Needed
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(1, 1, 1, 1, 1), 2))  // Expected: 5

    // Test Case 3: All Zeros, Replace All
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(0, 0, 0, 0), 2))  // Expected: 2

    // Test Case 4: Single Element Array (1)
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(1), 1))  // Expected: 1

    // Test Case 5: Single Element Array (0)
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(0), 1))  // Expected: 1

    // Test Case 6: No Zeros, All Ones
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(1, 1, 1, 1, 1, 1), 0))  // Expected: 6

    // Test Case 7: Zeros More Than k, Replacements Exhausted
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(1, 0, 0, 0, 1, 1, 0, 0, 1), 2))  // Expected: 4

    // Test Case 8: Zeros at the Edges
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(0, 1, 1, 1, 0), 1))  // Expected: 5

    // Test Case 9: Large Input with Mixed Values
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1), 3))  // Expected: 11

    // Test Case 10: Empty Array
    println(longestSubarrayWithOnesAfterReplacementBruteForce(intArrayOf(), 2))  // Expected: 0
}
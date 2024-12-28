package SlidingWindow.LongestSubarrayWithOnesAfterReplacement

fun longestSubarrayWithOnesAfterReplacementOptimal(nums: IntArray, k: Int): Int {

    var start = 0
    var maxLength = 0
    var zeroCount = 0

    for (end in nums.indices) {
        if (nums[end] == 0) zeroCount++
        while (zeroCount > k) {
            if (nums[start] == 0) zeroCount--
            start++
        }

        maxLength = maxOf(maxLength, end-start+1)
    }

    return maxLength
}

fun main() {
    // Test Case 1: Basic Test Case
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(1, 0, 1, 1, 0, 1, 0, 1, 1), 2))  // Expected: 7

    // Test Case 2: All Ones, No Replacement Needed
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(1, 1, 1, 1, 1), 2))  // Expected: 5

    // Test Case 3: All Zeros, Replace All
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(0, 0, 0, 0), 2))  // Expected: 2

    // Test Case 4: Single Element Array (1)
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(1), 1))  // Expected: 1

    // Test Case 5: Single Element Array (0)
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(0), 1))  // Expected: 1

    // Test Case 6: No Zeros, All Ones
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(1, 1, 1, 1, 1, 1), 0))  // Expected: 6

    // Test Case 7: Zeros More Than k, Replacements Exhausted
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(1, 0, 0, 0, 1, 1, 0, 0, 1), 2))  // Expected: 5

    // Test Case 8: Zeros at the Edges
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(0, 1, 1, 1, 0), 1))  // Expected: 4

    // Test Case 9: Large Input with Mixed Values
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1), 3))  // Expected: 11

    // Test Case 10: Empty Array
    println(longestSubarrayWithOnesAfterReplacementOptimal(intArrayOf(), 2))  // Expected: 0
}
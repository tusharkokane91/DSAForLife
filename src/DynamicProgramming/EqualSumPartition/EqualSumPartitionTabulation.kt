package DynamicProgramming.EqualSumPartition

fun equalSumPartitionTabulation(nums: IntArray): Boolean {
    val n = nums.size
    val sum = nums.sum()
    if (sum % 2 != 0) return false

    val target = sum/2
    val dp = Array(n+1) { BooleanArray(target+1) { false } }

    // Base case -> target of 0 is always achievable
    for (i in 0..n) {
        dp[i][0] = true
    }

    // Remember that the index of dp array is 1 step ahead of the index of nums array.
    for (index in 1..n) {
        val currentNumber = nums[index-1]
        for (currentTarget in 1..target) {
            if (currentNumber > currentTarget) {
                dp[index][currentTarget] = dp[index-1][currentTarget]
            } else {
                val exclude = dp[index-1][currentTarget]
                val include = dp[index-1][currentTarget - currentNumber]
                dp[index][currentTarget] = exclude || include
            }
        }
    }

    return dp[n][target]
}

fun main() {
    // Normal Case: Should return true
    println(equalSumPartitionTabulation(intArrayOf(1, 5, 11, 5))) // Expected: true

    // Normal Case: Should return false
    println(equalSumPartitionTabulation(intArrayOf(1, 2, 3, 5))) // Expected: false

    // Empty Array: Should return false
    println(equalSumPartitionTabulation(intArrayOf())) // Expected: false

    // Single Element: Should return false
    println(equalSumPartitionTabulation(intArrayOf(1))) // Expected: false

    // All Same Elements:
    println(equalSumPartitionTabulation(intArrayOf(1, 1, 1, 1))) // Expected: true for even count, false for odd

    // Large Numbers:
    println(equalSumPartitionTabulation(intArrayOf(1000, 2000, 1500, 1500))) // Expected: true

    // Negative Numbers:
    println(equalSumPartitionTabulation(intArrayOf(-1, 1, 2, -2))) // Expected: true

    // Sum is Odd:
    println(equalSumPartitionTabulation(intArrayOf(1, 2, 3))) // Expected: false

    // Only one number can match the sum:
    println(equalSumPartitionTabulation(intArrayOf(10, 5, 5, 1))) // Expected: true

    // All numbers sum up to zero:
    println(equalSumPartitionTabulation(intArrayOf(-1, 1, -2, 2))) // Expected: true

    // Large array with a solution:
    println(equalSumPartitionTabulation(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 10, 10, 10, 10, 10))) // Expected: true

    // No solution even with all numbers:
    println(equalSumPartitionTabulation(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))) // Expected: false
}

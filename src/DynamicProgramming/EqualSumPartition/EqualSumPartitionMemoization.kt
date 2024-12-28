package DynamicProgramming.EqualSumPartition

fun equalSumPartitionMemoization(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 != 0) return false
    val target = sum/2
    val n = nums.size
    val memo = Array(n+1) { BooleanArray(target+1) { false } }
    
    fun subsetSumMemoization(nums: IntArray, target: Int, n: Int): Boolean {
        if (n == 0) return false
        if (target == 0) return true
        
        if (memo[n][target]) return memo[n][target]
        
        memo[n][target] = if (nums[n-1] > target) {
            subsetSumMemoization(nums, target, n-1)
        } else {
            val exclude = subsetSumMemoization(nums, target, n-1)
            val include = subsetSumMemoization(nums, target - nums[n-1], n-1)
            exclude || include
        }
        
        return memo[n][target]
    }
    
    return subsetSumMemoization(nums, target, n)
}

fun main() {
    // Normal Case: Should return true
    println(equalSumPartitionMemoization(intArrayOf(1, 5, 11, 5))) // Expected: true

    // Normal Case: Should return false
    println(equalSumPartitionMemoization(intArrayOf(1, 2, 3, 5))) // Expected: false

    // Empty Array: Should return false
    println(equalSumPartitionMemoization(intArrayOf())) // Expected: false

    // Single Element: Should return false
    println(equalSumPartitionMemoization(intArrayOf(1))) // Expected: false

    // All Same Elements:
    println(equalSumPartitionMemoization(intArrayOf(1, 1, 1, 1))) // Expected: true for even count, false for odd

    // Large Numbers:
    println(equalSumPartitionMemoization(intArrayOf(1000, 2000, 1500, 1500))) // Expected: true

    // Negative Numbers:
    println(equalSumPartitionMemoization(intArrayOf(-1, 1, 2, -2))) // Expected: true

    // Sum is Odd:
    println(equalSumPartitionMemoization(intArrayOf(1, 2, 3))) // Expected: false

    // Only one number can match the sum:
    println(equalSumPartitionMemoization(intArrayOf(10, 5, 5, 1))) // Expected: true

    // All numbers sum up to zero:
    println(equalSumPartitionMemoization(intArrayOf(-1, 1, -2, 2))) // Expected: true

    // Large array with a solution:
    println(equalSumPartitionMemoization(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 10, 10, 10, 10, 10))) // Expected: true

    // No solution even with all numbers:
    println(equalSumPartitionMemoization(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))) // Expected: false
}

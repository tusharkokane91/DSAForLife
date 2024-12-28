package DynamicProgramming.EqualSumPartition

fun equalSumPartitionRecursive(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 != 0) return false
    val target = sum/2

    fun subsetSum(nums: IntArray, target: Int, n: Int): Boolean {
        if (n == 0) return false
        if (target == 0) return true

        return if (nums[n-1] > target) {
            subsetSum(nums, target, n-1)
        } else {
            subsetSum(nums, target, n-1) || subsetSum(nums, target-nums[n-1], n-1)
        }
    }

    return subsetSum(nums, target, nums.size)
}

fun main() {
    // Normal Case: Should return true
    println(equalSumPartitionRecursive(intArrayOf(1, 5, 11, 5))) // Expected: true

    // Normal Case: Should return false
    println(equalSumPartitionRecursive(intArrayOf(1, 2, 3, 5))) // Expected: false

    // Empty Array: Should return false
    println(equalSumPartitionRecursive(intArrayOf())) // Expected: false

    // Single Element: Should return false
    println(equalSumPartitionRecursive(intArrayOf(1))) // Expected: false

    // All Same Elements:
    println(equalSumPartitionRecursive(intArrayOf(1, 1, 1, 1))) // Expected: true for even count, false for odd

    // Large Numbers:
    println(equalSumPartitionRecursive(intArrayOf(1000, 2000, 1500, 1500))) // Expected: true

    // Negative Numbers:
    println(equalSumPartitionRecursive(intArrayOf(-1, 1, 2, -2))) // Expected: true

    // Sum is Odd:
    println(equalSumPartitionRecursive(intArrayOf(1, 2, 3))) // Expected: false

    // Only one number can match the sum:
    println(equalSumPartitionRecursive(intArrayOf(10, 5, 5, 1))) // Expected: true

    // All numbers sum up to zero:
    println(equalSumPartitionRecursive(intArrayOf(-1, 1, -2, 2))) // Expected: true

    // Large array with a solution:
    println(equalSumPartitionRecursive(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 10, 10, 10, 10, 10))) // Expected: true

    // No solution even with all numbers:
    println(equalSumPartitionRecursive(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))) // Expected: false
}

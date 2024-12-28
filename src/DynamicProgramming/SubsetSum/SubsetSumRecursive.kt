package DynamicProgramming.SubsetSum

/**
 * Time complexity
 *  - O(2^n) where n is the length of the array
 *
 * Space complexity
 *  - O(n) which is the maximum depth of the recursion stack
 */
fun subsetSumRecursive(nums: IntArray, target: Int, n: Int): Boolean {

    // Base case
    if (n == 0) return false
    if (target == 0) return true

    return if (nums[n-1] > target) {
        // If current number is greater than target, exclude it.
        subsetSumRecursive(nums, target, n-1)
    } else {
        // If current number is less than or equal to target, make a recursive call to check if we can include or exclude it.
        subsetSumRecursive(nums, target, n-1) || subsetSumRecursive(nums, target-nums[n-1], n-1 )
    }
}

fun main() {
    val nums = intArrayOf(3, 34, 4, 12, 5, 2)
    val target = 9
    println("Subset sum exists (recursive): ${subsetSumRecursive(nums, target, nums.size)}")
}

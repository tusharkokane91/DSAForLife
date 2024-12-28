package DynamicProgramming.SubsetSum

/**
 * Memoization approach with recursion
 *
 * Time complexity
 *  - O(n * target) as each state is solved at most once.
 *
 * Space complexity
 *  - O(n * target) for the 2D table memo + O(n) for the recursion stack.
 */
fun subsetSumMemoization(nums: IntArray, target: Int, n: Int, memo: Array<BooleanArray>): Boolean {

    if (n == 0) return false // return from here since if we do not, we get index out of bound exception later
    if (target == 0) return true // return from here since if we do not, we get index out of bound exception later

    if (memo[n][target]) return memo[n][target] // if the value exists, return it

    memo[n][target] = if (nums[n-1] > target) {
        /*
          If the current number is greater than the target, we have to exclude it.
         */
        subsetSumMemoization(nums, target, n-1, memo)
    } else {
        /*
          If the current number is less than or equal to the target, we need to decide if we need to include or exclude it.

          If both include and exclude are false, that means for this state of the dp array, a subset sum cannot be achieved.

          If any one of them comes to be true, that mean a subset sum is achievable.
         */
        val include = subsetSumMemoization(nums, target-nums[n-1], n-1, memo)
        val exclude = subsetSumMemoization(nums, target, n-1, memo)
        include || exclude
    }

    /*
      memo[i][j] represents whether the subset of first j elements can sum up to j.
     */
    return memo[n][target]
}

fun main() {
    val nums = intArrayOf(3, 34, 4, 12, 5, 2)
    val target = 9
    val n = nums.size
    val memo = Array(n+1) { BooleanArray(target+1) { false } }
    println("Subset sum exists (memoization): ${subsetSumMemoization(nums, target, n, memo)}")
}

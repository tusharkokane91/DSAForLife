package DynamicProgramming.SubsetSum

/**
 * Bottom-up approach without recursion
 */
fun subsetSumTabulation(nums: IntArray, target: Int): Boolean {

    val n = nums.size
    val dp = Array(n+1) { BooleanArray(target+1) { false } }

    /*
      Base case -> target of 0 can always be achieved

      We do not need to explicitly write the second base case for an empty array, as all the values in the array are already
      initialised to false.
     */
    for (i in 0..n) {
        dp[i][0] = true
    }

    /*
      Always remember this in a DP problem that the index of dp array is running +1 ahead of the nums array. So, for the current
      iteration with index, if we need current nums element, that would be nums[i-1].
     */
    for (index in 1..n) {
        val currentNumber = nums[index-1]
        for (currentTarget in 1..target) {
            if (currentNumber > currentTarget) {
                dp[index][currentTarget] = dp[index-1][currentTarget]
            } else {
                dp[index][currentTarget] = dp[index-1][currentTarget] || dp[index-1][currentTarget-currentNumber]
            }
        }
    }

    return dp[n][target]
}

fun main() {
    val nums = intArrayOf(3, 34, 4, 12, 5, 2)
    val target = 9
    println("Subset sum exists (tabulation): ${subsetSumTabulation(nums, target)}")
}

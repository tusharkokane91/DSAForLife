package DynamicProgramming.SubsetSum

fun subsetSumOptimized(nums: IntArray, target: Int): Boolean {

    val isSubsetSumPossibleForGivenTarget = BooleanArray(target+1) { false }
    isSubsetSumPossibleForGivenTarget[0] = true

    for (index in nums.indices) {
        val currentNumber = nums[index]
        for (currentTarget in target downTo currentNumber) {
            isSubsetSumPossibleForGivenTarget[currentTarget] =
                isSubsetSumPossibleForGivenTarget[currentTarget] || isSubsetSumPossibleForGivenTarget[currentTarget - currentNumber]
        }
    }

    return isSubsetSumPossibleForGivenTarget[target]
}

fun main() {
    val testCases = listOf(
        // Basic test case: Subset sum exists
        Pair(intArrayOf(3, 34, 4, 12, 5, 2), 9), // Expected: true

        // Edge case: Empty array, target > 0
        Pair(intArrayOf(), 1), // Expected: false

        // Edge case: Empty array, target = 0
        Pair(intArrayOf(), 0), // Expected: true

        // Edge case: Single element equals the target
        Pair(intArrayOf(7), 7), // Expected: true

        // Edge case: Single element less than target
        Pair(intArrayOf(5), 10), // Expected: false

        // General case: Target can be achieved by multiple subsets
        Pair(intArrayOf(2, 3, 7, 8, 10), 11), // Expected: true (2 + 3 + 7 or 8 + 3)

        // Edge case: Target not achievable
        Pair(intArrayOf(1, 2, 5), 4), // Expected: false

        // Edge case: All elements larger than the target
        Pair(intArrayOf(11, 12, 13), 10), // Expected: false

        // Edge case: Target is zero
        Pair(intArrayOf(1, 2, 3), 0), // Expected: true (empty subset)

        // Large array with a possible subset sum
        Pair((1..50).toList().toIntArray(), 100), // Expected: true
    )

    for ((nums, target) in testCases) {
        println("Input: nums = ${nums.joinToString()}, target = $target")
        println("Subset sum exists (space-optimized): ${subsetSumOptimized(nums, target)}")
        println()
    }
}


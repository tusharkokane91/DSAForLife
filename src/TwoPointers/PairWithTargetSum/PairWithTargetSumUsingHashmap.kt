package TwoPointers.pairWithTargetSumOptimal

fun pairWithTargetSumUsingHashmap(nums: IntArray, target: Int): List<Int> {
    val listOfIndices = mutableListOf<Int>()
    var numsMap = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val index = numsMap[target - nums[i]]
        if (index != null) {
            return listOfIndices.apply {
                add(index)
                add(i)
            }
        } else {
            numsMap[nums[i]] = i
        }
    }

    return listOfIndices
}

fun main() {
    // Test cases for the pairWithTargetSumOptimal function

    // Test case 1: Target sum is 6, array is [1, 2, 3, 4, 6]
    println(pairWithTargetSumUsingHashmap(intArrayOf(1, 2, 3, 4, 6), 6))  // Expected: [1, 3]

    // Test case 2: Target sum is 10, array is [2, 3, 5, 8, 11]
    println(pairWithTargetSumUsingHashmap(intArrayOf(2, 3, 5, 8, 11), 10))  // Expected: [0, 2]

    // Test case 3: Target sum is 5, array is [-3, 0, 1, 4, 8]
    println(pairWithTargetSumUsingHashmap(intArrayOf(-3, 0, 1, 4, 8), 5))  // Expected: [1, 4]

    // Test case 4: Target sum is 17, array is [1, 5, 7, 10, 12]
    println(pairWithTargetSumUsingHashmap(intArrayOf(1, 5, 7, 10, 12), 17)) // Expected: [2, 3]

    // Test case 5: Target sum is 9, array is [1, 2, 3, 4, 5, 6]
    println(pairWithTargetSumUsingHashmap(intArrayOf(1, 2, 3, 4, 5, 6), 9))  // Expected: [3, 5]

    // Test case 6: Target sum is 0, array is [-3, -2, -1, 0, 1, 2]
    println(pairWithTargetSumUsingHashmap(intArrayOf(-3, -2, -1, 0, 1, 2), 0))  // Expected: [2, 3]

    // Test case 7: Target sum is 7, array is [1, 3, 5, 7, 9]
    println(pairWithTargetSumUsingHashmap(intArrayOf(1, 3, 5, 7, 9), 7))  // Expected: [0, 3]

    // Test case 8: Target sum is 20, array is [2, 3, 8, 12, 18]
    println(pairWithTargetSumUsingHashmap(intArrayOf(2, 3, 8, 12, 18), 20))  // Expected: [1, 4]
}

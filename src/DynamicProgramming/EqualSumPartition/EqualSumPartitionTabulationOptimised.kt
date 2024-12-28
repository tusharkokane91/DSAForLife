package DynamicProgramming.EqualSumPartition

fun equalSumPartitionOptimised(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum %2 != 0) return false
    val target = sum/2
    
    /*
      The fact that in any given iteration in tabulation approach, we only need to look at the i-1 th row, that is the previous
      row in dp array, allows us to use a 1D array. At any given point, the new value can be the previous value(if we exclude the 
      current element) or the updated value.
     */
    val isEqualSumPartitionPossibleForGivenTarget = BooleanArray(target+1) { false }

    // Base case
    isEqualSumPartitionPossibleForGivenTarget[0] = true
    
    for (currentNumber in nums) {
        for (currentTarget in target downTo 0) {
            if (currentNumber <= currentTarget) {
                isEqualSumPartitionPossibleForGivenTarget[currentTarget] = isEqualSumPartitionPossibleForGivenTarget[currentTarget]
                        || isEqualSumPartitionPossibleForGivenTarget[currentTarget-currentNumber]
            }
        }
    }
    
    return isEqualSumPartitionPossibleForGivenTarget[target]
}

fun main() {
    // Normal Case: Should return true
    println(equalSumPartitionOptimised(intArrayOf(1, 5, 11, 5))) // Expected: true

    // Normal Case: Should return false
    println(equalSumPartitionOptimised(intArrayOf(1, 2, 3, 5))) // Expected: false

    // Empty Array: Should return false
    println(equalSumPartitionOptimised(intArrayOf())) // Expected: false

    // Single Element: Should return false
    println(equalSumPartitionOptimised(intArrayOf(1))) // Expected: false

    // All Same Elements:
    println(equalSumPartitionOptimised(intArrayOf(1, 1, 1, 1))) // Expected: true for even count, false for odd

    // Large Numbers:
    println(equalSumPartitionOptimised(intArrayOf(1000, 2000, 1500, 1500))) // Expected: true

    // Negative Numbers:
    println(equalSumPartitionOptimised(intArrayOf(-1, 1, 2, -2))) // Expected: true

    // Sum is Odd:
    println(equalSumPartitionOptimised(intArrayOf(1, 2, 3))) // Expected: false

    // Only one number can match the sum:
    println(equalSumPartitionOptimised(intArrayOf(10, 5, 5, 1))) // Expected: true

    // All numbers sum up to zero:
    println(equalSumPartitionOptimised(intArrayOf(-1, 1, -2, 2))) // Expected: true

    // Large array with a solution:
    println(equalSumPartitionOptimised(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 10, 10, 10, 10, 10))) // Expected: true

    // No solution even with all numbers:
    println(equalSumPartitionOptimised(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))) // Expected: false
}

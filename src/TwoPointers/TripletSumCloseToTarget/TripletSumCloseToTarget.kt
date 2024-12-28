package TwoPointers.TripletSumCloseToTarget

import kotlin.math.abs

fun tripletSumCloseToTarget(nums: IntArray, target: Int): Int {
    var smallestDistanceFromTarget = Int.MAX_VALUE
    var closestSum = Int.MAX_VALUE
    nums.sort()

    for (i in nums.indices) {
        /*
          From this point onwards, this becomes similar to target sum problem with target as the current number nums[i].
         */
        var start = i+1
        var end = nums.size-1

        while (start < end) {
            val currentSum = nums[i] + nums[start] + nums[end]
            if (abs(target - currentSum) < smallestDistanceFromTarget) {
                closestSum = currentSum
                smallestDistanceFromTarget = target - currentSum
            }

            if (currentSum == target) {
                return currentSum
            } else if (currentSum < target) {
                start++
            } else {
                end--
            }
        }
    }

    return closestSum
}

fun main() {
    val nums1 = intArrayOf(-2, 0, 1, 2)
    val target1 = 2
    println(tripletSumCloseToTarget(nums1, target1)) // Output: 1

    val nums2 = intArrayOf(-3, -1, 1, 2)
    val target2 = 1
    println(tripletSumCloseToTarget(nums2, target2)) // Output: 0

    val nums3 = intArrayOf(1, 1, 1, 0)
    val target3 = 100
    println(tripletSumCloseToTarget(nums3, target3)) // Output: 3

    val nums4 = intArrayOf(0, 0, 0)
    val target4 = 1
    println(tripletSumCloseToTarget(nums4, target4)) // Output: 0
}
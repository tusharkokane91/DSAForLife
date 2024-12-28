package TwoPointers.TripletsWithSmallerSum

/**
 * Time complexity = O(n^2) -> )(n.logn) for sorting + O(n) for the iteration and for each iteration, we run a target sum algorithm which takes O(n)
 * Space complexity = O(1) -> no additional space needed
 */
fun tripletsWithSmallerSum(nums: IntArray, target: Int): Int {
    nums.sort() // N.LogN
    var count = 0

    for (i in nums.indices) {
        /*
          For each iteration, we need to find if the currentSum is less than target - nums[i]. This essentially transforms
          this problem into a calculating target sum problem for each iteration.
         */
        var start = i+1
        var end = nums.size-1

        while (start < end) {
            val currentSum = nums[i] + nums[start] + nums[end]
            if (currentSum < target) {
                /*
                  One thing to note here is that, the number of pairs between start and end is equal to (end-start). Since
                  nums[start] + nums[end] is already less than the target sum, all the pairs between start and end must be
                  counted.
                 */
                count += (end - start)
                start++
            } else {
                end--
            }
        }
    }

    return count
}

fun main() {
    val nums1 = intArrayOf(-1, 0, 2, 3)
    val target1 = 3
    println(tripletsWithSmallerSum(nums1, target1)) // Output: 2

    val nums2 = intArrayOf(-1, 4, 2, 1, 3)
    val target2 = 5
    println(tripletsWithSmallerSum(nums2, target2)) // Output: 4

    val nums3 = intArrayOf(1, 1, -1, 0)
    val target3 = 2
    println(tripletsWithSmallerSum(nums3, target3)) // Output: 3

    val nums4 = intArrayOf(1, 2, 3, 4, 5)
    val target4 = 8
    println(tripletsWithSmallerSum(nums4, target4)) // Output: 2
}
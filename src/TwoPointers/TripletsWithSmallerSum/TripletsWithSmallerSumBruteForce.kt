package TwoPointers.tripletsWithSmallerSumBruteForce

fun tripletsWithSmallerSumBruteForce(nums: IntArray, target: Int): Int {
    var count = 0

    for (i in nums.indices) {
        for (j in i+1 until nums.size) {
            for (k in j+1 until nums.size) {
                if (nums[i] + nums[j] + nums[k] < target) count++
            }
        }
    }

    return count
}

fun main() {
    val nums1 = intArrayOf(-1, 0, 2, 3)
    val target1 = 3
    println(tripletsWithSmallerSumBruteForce(nums1, target1)) // Output: 2

    val nums2 = intArrayOf(-1, 4, 2, 1, 3)
    val target2 = 5
    println(tripletsWithSmallerSumBruteForce(nums2, target2)) // Output: 4

    val nums3 = intArrayOf(1, 1, -1, 0)
    val target3 = 2
    println(tripletsWithSmallerSumBruteForce(nums3, target3)) // Output: 3

    val nums4 = intArrayOf(1, 2, 3, 4, 5)
    val target4 = 8
    println(tripletsWithSmallerSumBruteForce(nums4, target4)) // Output: 2
}
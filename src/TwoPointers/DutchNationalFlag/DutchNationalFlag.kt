package TwoPointers.DutchNationalFlag

fun sortColors(nums: IntArray) {
    var start = 0
    var end = nums.size-1
    var index = 0

    while (index <= end) {
        when (nums[index]) {
            0 -> {
                /*
                  In this case, since we are swapping nums[index] with nums[start] which is already processed and cannot be
                  greater than the updated nums[index]
                 */
                nums[start] = nums[index].also { nums[index] = nums[start] }
                start++
                index++
            }
            2 -> {
                /*
                  In this case, we do not increment index since nums[index] has been updated now, and we want the
                  updated nums[index] to go through the iteration again. The last example is the case for that.
                 */
                nums[end] = nums[index].also { nums[index] = nums[end] }
                end--
            }
            1 -> { index++ }
        }
    }
}

fun main() {
    println("\nOptimal Approach:")

    // Regular case with 0s, 1s, and 2s
    val nums8 = intArrayOf(2, 0, 2, 1, 1, 0)
    sortColors(nums8)
    println(nums8.contentToString()) // Expected Output: [0, 0, 1, 1, 2, 2]

    // Case with all elements being 0
    val nums9 = intArrayOf(0, 0, 0, 0)
    sortColors(nums9)
    println(nums9.contentToString()) // Expected Output: [0, 0, 0, 0]

    // Case with all elements being 1
    val nums10 = intArrayOf(1, 1, 1, 1)
    sortColors(nums10)
    println(nums10.contentToString()) // Expected Output: [1, 1, 1, 1]

    // Case with all elements being 2
    val nums11 = intArrayOf(2, 2, 2, 2)
    sortColors(nums11)
    println(nums11.contentToString()) // Expected Output: [2, 2, 2, 2]

    // Empty array
    val nums12 = intArrayOf()
    sortColors(nums12)
    println(nums12.contentToString()) // Expected Output: []

    // Case with only 0s and 1s
    val nums13 = intArrayOf(1, 0, 1, 0, 1, 0)
    sortColors(nums13)
    println(nums13.contentToString()) // Expected Output: [0, 0, 0, 1, 1, 1]

    // Test case where the numbers are already sorted
    val nums14 = intArrayOf(0, 1, 2, 2, 1, 0)
    sortColors(nums14)
    println(nums14.contentToString()) // Expected Output: [0, 0, 1, 1, 2, 2]
}
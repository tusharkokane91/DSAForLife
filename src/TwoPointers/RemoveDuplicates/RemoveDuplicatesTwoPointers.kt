package TwoPointers.RemoveDuplicates

fun removeDuplicates(nums: IntArray): Int {
    var slow = 1
    for (fast in 1 until nums.size) {
        /**
         * If there is a duplicate element, slow pointer will lag behind of fast.
         *
         * In any case, keep assigning the value at fast pointer as the value at slow pointer and keep moving forward. Increment
         * the slow pointer only if the current element is not equal to the previous element.
         *
         * All of this logic holds true only on the assumption that the input is a sorted array of integers.
         */
        if (nums[fast] != nums[fast-1]) {
            nums[slow] = nums[fast]
            slow++
        }
    }

    return slow
}

fun main() {
    // Test Case 1: nums = [1, 1, 2]
    val nums1 = intArrayOf(1, 1, 2)
    val len1 = removeDuplicates(nums1)
    println("New length: $len1, Array: ${nums1.take(len1)}")  // Expected Output: New length: 2, Array: [1, 2]

    // Test Case 2: nums = [0, 0, 1, 1, 1, 2, 2, 3]
    val nums2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3)
    val len2 = removeDuplicates(nums2)
    println("New length: $len2, Array: ${nums2.take(len2)}")  // Expected Output: New length: 4, Array: [0, 1, 2, 3]

    // Test Case 3: nums = [1, 2, 2, 3, 4, 4, 5]
    val nums3 = intArrayOf(1, 2, 2, 3, 4, 4, 5)
    val len3 = removeDuplicates(nums3)
    println("New length: $len3, Array: ${nums3.take(len3)}")  // Expected Output: New length: 5, Array: [1, 2, 3, 4, 5]

    // Test Case 4: nums = [1]
    val nums4 = intArrayOf(1)
    val len4 = removeDuplicates(nums4)
    println("New length: $len4, Array: ${nums4.take(len4)}")  // Expected Output: New length: 1, Array: [1]
}

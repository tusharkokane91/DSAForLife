package SlidingWindow.FindMaxSumForSubarray

// You should have a top level function called main

fun main(args: Array<String>) {
    val arr = intArrayOf(2, 1, 5, 1, 3, 2)
    val k = 3

    val maxSum = findMaxSumForK(arr,k)
    println("max sum is $maxSum")
}

fun findMaxSumForK(arr: IntArray, k: Int): Int {
    // Define a maxSum var to keep track of the maximum sum we have encountered so far in the array
    var maxSum = 0
    // Define a windowSum var to keep track of the current window's sum
    var windowSum = 0
    // Define a windowStart var as a moving pointer at the start for the sliding window
    var windowStart = 0

    // This initialisation is needed because in the second for loop, we start with sliding the window by 1 and cannot do
    // this initialisation in that for loop.
    for (i in 0 until k) {
        windowSum += arr[i]
    }
    maxSum = windowSum

    for (windowEnd in k until arr.size) {
        windowSum += arr[windowEnd] - arr[windowStart]
        windowStart++
        maxSum = maxOf(maxSum, windowSum)
    }

    return maxSum
}
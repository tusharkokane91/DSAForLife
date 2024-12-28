The "Maximum Sum Subarray of Size K" problem is a classic sliding window problem where the goal is to find the maximum sum of any contiguous subarray of size
𝐾
K within a given array.

Problem Statement
Given an array of positive integers arr and an integer K, find the maximum sum of a subarray of size
𝐾
K.

Example
Input:
text
Copy code
arr = [2, 1, 5, 1, 3, 2]
K = 3
Output:
text
Copy code
9
Explanation:
The subarray [5, 1, 3] has the maximum sum of
9
9.

Solution Approaches
1. Brute Force Approach
   The brute force approach calculates the sum of every possible subarray of size
   𝐾
   K and keeps track of the maximum sum encountered.

Algorithm
Iterate through the array, fixing a starting point for the subarray.
For each starting point, calculate the sum of the next
𝐾
K elements.
Update the maximum sum encountered.
Return the maximum sum.
Code
kotlin
Copy code
fun maxSumSubarrayOfSizeKBruteForce(arr: IntArray, k: Int): Int {
var maxSum = 0

    for (i in 0..arr.size - k) {
        var currentSum = 0
        for (j in i until i + k) {
            currentSum += arr[j]
        }
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}
Time Complexity
Outer loop iterates
𝑁
−
𝐾
+
1
N−K+1 times (
𝑁
N is the size of the array).
Inner loop iterates
𝐾
K times for each starting index.
Total Complexity:
𝑂
(
𝑁
×
𝐾
)
O(N×K)
Space Complexity
No extra space is used.
Space Complexity:
𝑂
(
1
)
O(1)
2. Optimal Approach (Sliding Window)
   The sliding window technique involves maintaining a running sum of a subarray of size
   𝐾
   K, adding the next element, and removing the previous element from the sum as we slide the window.

Algorithm
Start with a window containing the first
𝐾
K elements and calculate its sum.
Slide the window by:
Adding the next element to the sum.
Subtracting the element that is sliding out of the window.
Update the maximum sum encountered after each slide.
Return the maximum sum.
Code
kotlin
Copy code
fun maxSumSubarrayOfSizeKSlidingWindow(arr: IntArray, k: Int): Int {
var maxSum = 0
var windowSum = 0
var windowStart = 0

    // Initialize the first window
    for (i in 0 until k) {
        windowSum += arr[i]
    }
    maxSum = windowSum

    // Slide the window over the rest of the array
    for (windowEnd in k until arr.size) {
        windowSum += arr[windowEnd] - arr[windowStart]
        windowStart++
        maxSum = maxOf(maxSum, windowSum)
    }

    return maxSum
}
Time Complexity
The array is traversed once to maintain the window sum.
Total Complexity:
𝑂
(
𝑁
)
O(N)
Space Complexity
No extra space is used.
Space Complexity:
𝑂
(
1
)
O(1)
Comparison
Approach	Time Complexity	Space Complexity	Remarks
Brute Force
𝑂
(
𝑁
×
𝐾
)
O(N×K)
𝑂
(
1
)
O(1)	Inefficient for large
𝑁
N or
𝐾
K.
Sliding Window
𝑂
(
𝑁
)
O(N)
𝑂
(
1
)
O(1)	Optimal and suitable for large datasets.
Example Walkthrough
Input:
kotlin
Copy code
arr = [2, 1, 5, 1, 3, 2]
K = 3
Sliding Window Execution:
Initialize first window:
[
2
,
1
,
5
]
[2,1,5], sum =
8
8, maxSum =
8
8.
Slide window:
Add
1
1, remove
2
2: Window =
[
1
,
5
,
1
]
[1,5,1], sum =
7
7, maxSum =
8
8.
Add
3
3, remove
1
1: Window =
[
5
,
1
,
3
]
[5,1,3], sum =
9
9, maxSum =
9
9.
Add
2
2, remove
5
5: Window =
[
1
,
3
,
2
]
[1,3,2], sum =
6
6, maxSum =
9
9.
Return
9
9.
This approach ensures an efficient computation of the maximum sum.
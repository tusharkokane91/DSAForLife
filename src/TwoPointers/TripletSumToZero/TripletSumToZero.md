# Triplet Sum to Zero (medium)

## Problem statement
Given an array of integers, find all unique triplets that add up to zero. Each triplet
should be a set of three numbers a, b, c such that a+b+c=0.

## Example
```declarative
Input: nums = [-3, 0, 1, 2, -1, 1, -2]
Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
```

## Approaches
1. Brute force
2. Optimal approach using two pointers

### 1. Brute force approach
#### Algorithm
1. We need three `for` loops to iterate over the `nums` array while checking for each combination.
2. For each iteration, check if `nums[i] + nums[j] + nums[k] = 0`. If so, add these numbers to the
`result` list. Else, continue.
3. To keep the list free of duplicate elements, we instantiate `result` as a set of list of integers.
4. While returning, we convert the set to list.

#### Code
```kotlin
package TwoPointers.TripletSumToZero

fun tripletSumToZeroBruteForce(nums: IntArray): List<List<Int>> {
    // We use Set here to avoid duplicates being added.
    val result = mutableSetOf<List<Int>>()

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            for (k in j + 1 until nums.size) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(listOf(nums[i], nums[j], nums[k]).sorted())
                }
            }
        }
    }

    return result.toList()
}

fun main() {
    // Test Case 1: Mixed positives and negatives
    println(tripletSumToZeroBruteForce(intArrayOf(-3, 0, 1, 2, -1, 1, -2)))
    // Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]

    // Test Case 2: All negatives
    println(tripletSumToZeroBruteForce(intArrayOf(-5, -4, -3, -2, -1)))
    // Output: []

    // Test Case 3: All positives
    println(tripletSumToZeroBruteForce(intArrayOf(1, 2, 3, 4, 5)))
    // Output: []

    // Test Case 4: Contains zeros
    println(tripletSumToZeroBruteForce(intArrayOf(0, 0, 0, 0)))
    // Output: [[0, 0, 0]]

    // Test Case 5: Large array with duplicates
    println(tripletSumToZeroBruteForce(intArrayOf(-3, -3, 1, 2, 2, 0, -2, 1, -1)))
    // Output: [[-3, 1, 2], [-2, 0, 2], [-1, 0, 1]]

    // Test Case 6: Empty array
    println(tripletSumToZeroBruteForce(intArrayOf()))
    // Output: []

    // Test Case 7: Single element
    println(tripletSumToZeroBruteForce(intArrayOf(0)))
    // Output: []

    // Test Case 8: Two elements
    println(tripletSumToZeroBruteForce(intArrayOf(0, 1)))
    // Output: []
}
```

#### Time complexity
- `O(n^3)` due to three loops.

#### Space complexity
- `O(k)`, where `k` is the number if unique triplets being stored in the `result` set.

### 2. Optimal approach using two pointers
#### Note
- This basically boils down to target sum problem.
#### Algorithm
1. First, sort the array. Then start iterating over the array. Also maintain a set of list of Int `result`.
2. For each iteration ->
    - This now coverts into a two-sum problem where the target for each iteration is the negative current
    number at `nums[i]`. 
   - Find the numbers which sum up to `-nums[i]` and keep adding them to the `result`.

#### Code
```kotlin
package TwoPointers.TripletSumToZero

fun tripletSumToZeroOptimal(nums: IntArray): List<List<Int>> {
    nums.sort() // sort the incoming array
    val result = mutableSetOf<List<Int>>()

    for (i in nums.indices) {
        var start = i+1
        var end = nums.size - 1

        // This is basically target sum problem now with target sum as the current number in the iteration.
        while (start < end) {
            val currentSum = nums[start] + nums[end]
            if (currentSum == -nums[i]) { // if current sum is the exact negative of nums[i], that means their sum would be 0
                result.add(listOf(nums[i], nums[start], nums[end]))
                start++
                end--
            } else if (currentSum < -nums[i]) { // meaning the sum is less than 0
                start++
            } else { // meaning the sum is greater than 0
                end--
            }
            
            /*
            Alternative approach of calculating the current sum as per ChatGPT
            
            if (currentSum == 0) {
                result.add(listOf(i, start, end))
                start++
                end--
            } else if (currentSum < 0) {
                start++
            } else {
                end--
            }
             */
        }
    }

    return result.toList()
}

fun main() {
    // Test Case 1: Mixed positives and negatives
    println(tripletSumToZeroOptimal(intArrayOf(-3, 0, 1, 2, -1, 1, -2)))
    // Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]

    // Test Case 2: All negatives
    println(tripletSumToZeroOptimal(intArrayOf(-5, -4, -3, -2, -1)))
    // Output: []

    // Test Case 3: All positives
    println(tripletSumToZeroOptimal(intArrayOf(1, 2, 3, 4, 5)))
    // Output: []

    // Test Case 4: Contains zeros
    println(tripletSumToZeroOptimal(intArrayOf(0, 0, 0, 0)))
    // Output: [[0, 0, 0]]

    // Test Case 5: Large array with duplicates
    println(tripletSumToZeroOptimal(intArrayOf(-3, -3, 1, 2, 2, 0, -2, 1, -1)))
    // Output: [[-3, 1, 2], [-2, 0, 2], [-1, 0, 1]]

    // Test Case 6: Empty array
    println(tripletSumToZeroOptimal(intArrayOf()))
    // Output: []

    // Test Case 7: Single element
    println(tripletSumToZeroOptimal(intArrayOf(0)))
    // Output: []

    // Test Case 8: Two elements
    println(tripletSumToZeroOptimal(intArrayOf(0, 1)))
    // Output: []
}
```

#### Time complexity
- Sorting the array takes `O(n.logn)` time.
- Iterating over the array takes `O(n)` time and for each iteration, finding the numbers that add up to
negative of current number is `O(n)`. 
- That leaves us with a total time complexity of `O(n^2)`.

#### Space complexity
- `O(k)` where `k` is the number of unique triplets stored in the result.
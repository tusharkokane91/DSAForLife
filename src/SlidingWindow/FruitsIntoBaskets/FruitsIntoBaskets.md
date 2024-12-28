# Fruits into baskets(medium)

## Problem statement
Given an array of characters where each character represents a type of fruit and two baskets, your goal is to 
put `maximum number of fruits` in each basket. The only restriction is that `each basket can have only one
type of fruit`.

You can start with any tree, but once you start, you cannot skip a tree.

**Note** This basically boils down to `finding the length of the longest subarray which has at most
 2 disticnt characters`.

## Example
```declarative
Input: fruits = ['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: The longest subarray with at most 2 distinct fruits is ['C', 'A', 'C'].
```

## Approaches
There are two approaches to this problem as below.

1. Brute force approach
   - Check for each sub-array if it holds the condition for having at most 2 distinct characters.
   - Keep track of the max length while doing that.
2. Optimal approach using sliding window
    - Keep two pointers `start` and `end`.
    - `Expand(end++)` when the current sub-array still holds the condition true for having at most 2 distinct
   characters.
    - `Shrink(start++)` when the current sub-array does not hold the condition true for having at most 2
   distinct characters.


### 1. Brute force approach

#### Algorithm
1. Check for each sub-array if it holds the condition for having at most 2 distinct characters.
2. Keep track of the max length while doing that.

#### Code
```kotlin
package SlidingWindow.FruitsIntoBaskets

fun maxFruitsBruteForce(fruits: CharArray): Int {
    var maxLength = 0

    for (start in fruits.indices) {
        for (end in start until fruits.size) {
            /*
              Note:- sliceArray returns an array containing elements from start to end in the given array
             */
            val subArray = fruits.sliceArray(start..end)
            if (subArray.toSet().size <= 2) {
                maxLength = maxOf(maxLength, subArray.size)
            }
        }
    }

    return maxLength
}

fun main() {
    val fruits = charArrayOf('A', 'B', 'C', 'A', 'C')
    val result = maxFruitsBruteForce(fruits)
    println("Maximum fruits collected (Brute Force): $result")
}
```

#### Time complexity
- `Generating subarrays` takes `O(n^2)` time.
- `Checking if a subarray contains k distinct elements` takes `O(n)` time.
- Total time complexity comes to be `O(n^3)`.

#### Space complexity
- `O(n)` for storing the subarray during the process.

### 2. Optimal approach using sliding window
#### Algorithm
1. Keep two pointers `start` and `end`.
2. `Expand(end++)` when the current sub-array still holds the condition true for having at most 2 distinct
     characters.
3. `Shrink(start++)` when the current sub-array does not hold the condition true for having at most 2
     distinct characters.

#### Code
```kotlin
package SlidingWindow.FruitsIntoBaskets

fun maxFruits(fruits: CharArray): Int {
    if (fruits.isEmpty()) return 0

    var start = 0
    var maxLength = 0
    val fruitCount = mutableMapOf<Char, Int>()

    for (end in fruits.indices) {

        // Expand
        val currentFruit = fruits[end]
        fruitCount[currentFruit] = fruitCount.computeIfAbsent(currentFruit){0} + 1

        // Shrink
        while (fruitCount.size > 2) {
            val startFruit = fruits[start]
            fruitCount[startFruit] = fruitCount[startFruit]!! - 1
            if (fruitCount[startFruit] == 0) {
                fruitCount.remove(startFruit)
            }
            start++
        }

        // Keep track of max length we have encountered so far that matches the condition while we are expanding and
        // shrinking over the array
        maxLength = maxOf(maxLength, end-start+1)
    }

    return maxLength
}

fun main() {
    val fruits = charArrayOf('A', 'B', 'C', 'A', 'C')
    val result = maxFruits(fruits)
    println("Maximum fruits collected (Optimal): $result")
}
```

#### Time complexity
- Each character is processed at most twice, so time complexity is `O(n)`.

#### Space complexity
- `O(2)` = `O(1)` because the hash map will store at max 2 distinct fruits.

### **Comparison of Both Approaches**

| **Approach**        | **Time Complexity** | **Space Complexity** | **Pros**                                | **Cons**                                 |
|----------------------|---------------------|----------------------|-----------------------------------------|------------------------------------------|
| **Brute Force**      | \( O(N^3) \)        | \( O(N) \)           | Easy to understand                      | Inefficient for large inputs             |
| **Sliding Window**   | \( O(N) \)          | \( O(1) \)           | Efficient for large inputs              | Slightly more complex logic              |

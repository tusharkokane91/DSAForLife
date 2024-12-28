# Longest substring with K distinct characters(medium)

## Problem Statement
Given a string `s` and an integer `k`, find the length of the longest substring that contains at most `k` distinct characters.

## Example
```Kotlin
Input: s = "araaci", k = 2  
Output: 4  
Explanation: The longest substring with at most 2 distinct characters is "araa".
```

## Approaches
There are two approaches to this problem as below.
1. Brute force approach (simple but inefficient)
2. Optimal approach using `sliding window` technique (efficient)

### 1. Brute force approach
#### Algorithm
1. Iterate through all the possible substrings of the given string.
2. For each substring, check if it contains at most `k` distinct characters.
3. Keep track of the longest valid substring.

#### Code
```Kotlin
fun longestSubstringWithKDistinctBruteForce(s: String, k: Int): Int {
    // To keep track of the max length of a valid substring across all iterations
    var maxLength = 0

    for (start in s.indices) {
        for (end in start+1 until s.length) {
            val substring = s.substring(start, end)
            // We convert the string to set of distinct characters so that we can check if it contains at most k distinct characters
            if (substring.toSet().size <= k) {
                maxLength = maxOf(maxLength, substring.length)
            }
        }
    }

    return maxLength
}

fun main() {
    val s = "araaci"
    val k = 2
    val result = longestSubstringWithKDistinctBruteForce(s, k)
    println("Longest substring length (Brute Force): $result")
}
```

#### Time complexity
- Generating substrings takes `O(n)^2` where `n` is the length of the string.
- Checking distinct characters in each substring takes `O(n)`.
- So the total time complexity for brute force approach is `O(n)^3`.

#### Space complexity
- `O(n)` for storing the substring during the process.

### 2. Optimal approach using sliding window

#### Algorithm
1. Use two pointers `start` and `end` to maintain a window.
2. In each iteration of the `for` loop, check if the current substring has at most `k` distinct characters.
3. If the condition is true, update the `maxLength` var to the latest length and increment the `end` pointer. This is the `expansion` phase of our sliding window.
4. If the condition is not true, the `maxLenght` stays the same and we increment the `start` pointer. This is the `shrinking` phase of our sliding window.
5. At the end of the loop, we should have the max length of the substring with the given condition in `maxLength`.

#### Code
```kotlin
package SlidingWindow.LongestSubstringWithKDistinctCharacters

fun longestSubstringWithKDistinct(s: String, k: Int): Int {
    if (s.isEmpty() || k == 0) return 0

    var start = 0
    var maxLength = 0
    val charFrequency = mutableMapOf<Char, Int>()

    for (end in s.indices) {
        val currentChar = s[end]
        charFrequency[currentChar] = charFrequency.getOrDefault(currentChar, 0)  + 1

        while (charFrequency.size > k) {
            val startChar = s[start]
            charFrequency[startChar] = charFrequency[startChar]!! - 1
            if (charFrequency[startChar] == 0) {
                charFrequency.remove(startChar)
            }
            start++
        }

        maxLength = maxOf(maxLength, end-start+1)
    }

    return maxLength
}

fun main() {
    val s = "araaci"
    val k = 2
    val result = longestSubstringWithKDistinct(s, k)
    println("Longest substring length (Optimal): $result")
}
```

#### Time complexity
- Each character is processed at most twice, once while expanding and once while shrinking. 
- Hence, time complexity is `O(n)` where `n` is the length of the string.

#### Space complexity
- `O(k)` for hashmap to store up to `k` distinct characters.













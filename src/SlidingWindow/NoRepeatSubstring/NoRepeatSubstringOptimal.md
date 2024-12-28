# No-repeat substring(hard)

## Problem statement
Given a string `s`, find the length of the longest substring without repeating characters.

## Example
```declarative
Input: s = "abcabcbb"
Output: 3
Explanation: The longest substring without repeating characters is "abc".
```

```declarative
Input: s = "bbbbb"
Output: 1
Explanation: The longest substring without repeating characters is "b".
```

## Approaches
There are two approaches to this problem as below.

1. Brute force approach
2. Optimal approach using sliding window

### 1. Brute force approach

#### Algorithm
1. Iterate through the array to find each substring.
2. Validate for each substring, if it has unique characters.
3. While doing the iteration and validation, keep track of the max length of the substring that satisfies the given condition.

#### Code
```kotlin
package SlidingWindow.NoRepeatSubstring

fun findLongestSubstringWithNoRepeatingCharactersBruteForce(s: String): Int {
    if (s.isEmpty()) return 0

    var maxLength = 0

    for (start in s.indices) {
        for (end in start until s.length) {
            val substring = s.substring(start, end + 1)
            if (substring.toSet().size == substring.length) {
                maxLength = maxOf(maxLength, substring.length)
            }
        }
    }

    return maxLength
}

fun main() {
    val input = "abcdefghijklmnopqrstuvwxyz".repeat(10)
    val result = findLongestSubstringWithNoRepeatingCharactersBruteForce(input)
    println("Longest no-repeat substring length (Optimal): $result")
}
```

#### Time complexity
- Two loops take `O(n^2)`.
- For each iteration, calculation of substring and checking if that substring has unique characters
takes `O(n)`. 
- So the total time complexity is `O(n^3)`.

#### Space complexity
- `O(n)` to store the substring for each iteration.

### 2. Optimal approach using sliding window
#### Algorithm
1. Create a `maxLength` variable and initialise it to `0`.
2. Also create a `charSet` mutable set, initialised to empty set.
3. Maintain two pointers, `start` and `end`, both initialised to `0`.
4. For each iteration, add the current char to set. Now, check if the current `charSet` size is equal to
the current sliding window length. 
5. If it is equal, that means the current sliding window does not include any repeating characters.
6. If it is not equal, that means current sliding window has encountered repeating characters leading to this difference.
In this case, keep incrementing the `start` pointer till the size of the `charSet` and the length of the current sliding 
window become equal again.
7. Keep updating the `maxLength` to keep track of the length of the longest substring that satisfies
the given condition.

#### Code
```kotlin
package SlidingWindow.NoRepeatSubstring

fun findLongestSubstringWithNoRepeatingCharacters(s: String): Int {
    if (s.isEmpty()) return 0

    var start = 0
    var maxLength = 0
    val charSet = mutableSetOf<Char>()

    for (end in s.indices) {
        val currentChar = s[end]
        charSet.add(currentChar)

        /**
         * The charSet size should always be equal to the sliding window length. This ensures that in the current
         * window, does not have any repeating characters.
         *
         * If we encounter a repeating char, the length of slding window will be greater than the charSet size and in
         * that case, we need to keep moving our start pointer until charSet.size is equal to the sliding window length
         * again.
         */
        while (charSet.size != (end-start+1)) {
            val startChar = s[start]
            charSet.remove(startChar)
            start++
        }

        maxLength = maxOf(maxLength, end-start+1)
    }

    return maxLength
}

fun main() {
    val input = "abcdefghijklmnopqrstuvwxyz".repeat(10)
    val result = findLongestSubstringWithNoRepeatingCharacters(input)
    println("Longest no-repeat substring length (Optimal): $result")
}
```

#### Time complexity
- Each character is processed at most once while expanding the window and at most once while updating
the `start` pointer. 
- So the time complexity is `O(n)`.

#### Space complexity
- For worst case, when all the characters are unique, space complexity would be `O(n)` for storing all
the characters in the set.

### Edge test cases

| **Test Case Description**             | **Input**                    | **Expected Output** | **Explanation**                                                   |
|----------------------------------------|------------------------------|---------------------|-------------------------------------------------------------------|
| **Empty String**                       | `""`                         | `0`                 | No characters in the string.                                      |
| **Single Character**                   | `"a"`                        | `1`                 | The only substring is `"a"`.                                      |
| **All Same Characters**                | `"aaaa"`                     | `1`                 | Only one unique character, longest substring is `"a"`.            |
| **Two Same Characters**                | `"aa"`                       | `1`                 | Repeated characters, longest substring is `"a"`.                  |
| **Two Different Characters**           | `"ab"`                       | `2`                 | The whole string is unique.                                       |
| **String with Spaces**                 | `"a b c"`                    | `5`                 | Longest substring is `"a b c"` including spaces.                  |
| **String with Numbers**                | `"123123"`                   | `3`                 | The longest substring is `"123"`.                                 |
| **String with Special Characters**     | `"!@#$%^&*"`                 | `8`                 | All characters are unique.                                        |
| **Case Sensitivity**                   | `"AaBbCc"`                   | `6`                 | Distinct characters due to case sensitivity.                      |
| **Leading and Trailing Spaces**        | `" abcd "`                   | `5`                 | The longest substring is `" abcd"`.                               |
| **Unicode Characters**                 | `"😊😂😊"`                   | `2`                 | The longest substring is `"😊😂"`.                                |
| **String Ending with Repeats**         | `"abcdeffff"`                | `5`                 | The longest substring is `"abcde"`.                               |
| **String Starting with Repeats**       | `"aaaaabc"`                  | `3`                 | The longest substring is `"abc"`.                                 |
| **Non-ASCII Characters**               | `"абвгддгв"`                 | `5`                 | The longest substring is `"абвгд"`.                               |
| **Single Character Repeated Many Times** | `"a".repeat(1000)`         | `1`                 | Only `"a"` repeated, longest substring is `1`.                   |
| **Alternating Characters**             | `"abababab"`                 | `2`                 | The longest substring is `"ab"`.                                  |
| **Increasing Length Substring**        | `"aabbccddeeff"`             | `2`                 | Longest substrings are `"aa"`, `"bb"`, `"cc"`, etc.               |
| **Very Long String with All Unique Characters** | `"abcdefghijklmnopqrstuvwxyz".repeat(10)` | `26` | Each substring of length 26 contains all unique letters.          |

### Comparison of both approaches
| **Approach**       | **Time Complexity** | **Space Complexity** | **Pros**                        | **Cons**                          |
|---------------------|---------------------|----------------------|----------------------------------|-----------------------------------|
| **Brute Force**    | \( O(N^3) \)        | \( O(N) \)           | Easy to understand              | Inefficient for large inputs      |
| **Sliding Window** | \( O(N) \)          | \( O(N) \)           | Efficient for large inputs      | Slightly more complex logic       |


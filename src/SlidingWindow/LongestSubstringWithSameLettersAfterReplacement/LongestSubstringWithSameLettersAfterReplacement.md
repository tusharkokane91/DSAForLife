# Longest Substring with Same Letters after Replacement (hard)

## Problem statement
Given a string of lowercase English characters `s` and an integer `k`, find the length of the longes
substring containing the same letters you can get after replacing at most `k` characters.

## Example
```declarative
Input: s = "aababba", k = 1  
Output: 4  
Explanation: Replace the 'b' at index 2 to get "aaaa" or the 'b' at index 5 to get "aaab".
```
## Approaches
1. Brute force approach
2. Optimal approach using sliding window

### 1. Brute force approach

#### Algorithm
1. Iterate through each substring. 
2. For each substring, calculate how many characters need to be replaced in order to have all the characters
the same.
3. If the number of replacements is less than or equal to `k`, update the `maxLength`.

#### Code
```kotlin
package SlidingWindow.LongestSubstringWithSameLettersAfterReplacement

fun longestSubstringWithReplacementBruteForce(s: String, k: Int): Int {
    var maxLength = 0

    for (start in s.indices) {
        for (end in start until s.length) {
            val currentSubstring = s.substring(start, end+1)
            val maxCharCount = currentSubstring.groupingBy { it }.eachCount().values.maxOrNull() ?: 0
            val charsToReplace = currentSubstring.length - maxCharCount

            if (charsToReplace <= k) {
                maxLength = maxOf(maxLength, currentSubstring.length)
            }
        }
    }

    return maxLength
}

fun main() {
    // Edge Test Cases
    println(longestSubstringWithReplacementBruteForce("", 2))            // 0 - Empty string
    println(longestSubstringWithReplacementBruteForce("a", 0))           // 1 - Single character, no replacement
    println(longestSubstringWithReplacementBruteForce("a", 2))           // 1 - Single character, replacements allowed
    println(longestSubstringWithReplacementBruteForce("aaaaa", 2))       // 5 - All same characters
    println(longestSubstringWithReplacementBruteForce("aab", 0))         // 2 - No replacement allowed
    println(longestSubstringWithReplacementBruteForce("abcd", 3))        // 4 - All distinct characters, replace 3 to get longest substring
    println(longestSubstringWithReplacementBruteForce("aababba", 1))     // 4 - Replace 1 character to get "aaaa" or "aaab"
    println(longestSubstringWithReplacementBruteForce("abcde", 2))       // 3 - Replace 2 characters to get longest substring of 3
    println(longestSubstringWithReplacementBruteForce("ababaccc", 2))    // 5 - Replace 2 to get "cccccc"
    println(longestSubstringWithReplacementBruteForce("aabccbb", 2))     // 5 - Replace 2 to get "bbbbb"
}
```
#### Time complexity
- As we need to go over the string twice, time complexity is `O(n^2)`.

#### Space complexity
- `O(1)` as no additional data structures used to store the data.

### 2. Optimal approach using sliding window

#### Algorithm
1. Initialise `maxLength` to `0` which keeps track of the maximum length of the substring that satisfies the given criteria.
2. Initialise `charFrequencyMap` to empty map which keeps track of the count of every character in the string.
3. Initialise `maxCharFrequency` to 0 which keeps track of the maximum frequency encountered so far for the current window.
4. Initialise `start` pointer to `0` which is used as the start pointer of the sliding window.
5. For each iteration ->
   - Update the frequency for the current character in `charFrequencyMap`. 
   - Update the max char frequency encountered in the current window in `maxCharFrequency`.
   - Calculate the number of characters that need to be replaced as the difference between `end - start + 1` that is the length 
   of the current window and `maxCharFrequency`.
   - If this difference is `> k` , this means that the window needs to be shrunk now. 
   - Else, update the `maxLength` and keep expanding.

#### Code
```kotlin
package SlidingWindow.LongestSubstringWithSameLettersAfterReplacement

fun longestSubstringWithReplacementOptimal(s: String, k: Int): Int {
    var maxLength = 0
    var maxCharFrequency = 0
    var start = 0
    val charFrequencyMap = mutableMapOf<Char, Int>()

    for (end in s.indices) {
        val currentChar = s[end]
        charFrequencyMap[currentChar] = charFrequencyMap.getOrPut(currentChar){0} + 1
        maxCharFrequency = maxOf(maxCharFrequency, charFrequencyMap[currentChar]!!)

        val charsToReplace = (end - start + 1) - maxCharFrequency
        if (charsToReplace > k) {
            val startChar = s[start]
            charFrequencyMap[s[start]] = charFrequencyMap[startChar]!! - 1
            start++
        }

        maxLength = maxOf(maxLength, (end-start+1))
    }

    return maxLength
}

fun main() {
    // Edge Test Cases
    println(longestSubstringWithReplacementOptimal("", 2))            // 0 - Empty string
    println(longestSubstringWithReplacementOptimal("a", 0))           // 1 - Single character, no replacement
    println(longestSubstringWithReplacementOptimal("a", 2))           // 1 - Single character, replacements allowed
    println(longestSubstringWithReplacementOptimal("aaaaa", 2))       // 5 - All same characters
    println(longestSubstringWithReplacementOptimal("aab", 0))         // 2 - No replacement allowed
    println(longestSubstringWithReplacementOptimal("abcd", 3))        // 4 - All distinct characters, replace 3 to get longest substring
    println(longestSubstringWithReplacementOptimal("aababba", 1))     // 4 - Replace 1 character to get "aaaa" or "aaab"
    println(longestSubstringWithReplacementOptimal("abcde", 2))       // 3 - Replace 2 characters to get longest substring of 3
    println(longestSubstringWithReplacementOptimal("ababaccc", 2))    // 5 - Replace 2 to get "cccccc"
    println(longestSubstringWithReplacementOptimal("aabccbb", 2))     // 5 - Replace 2 to get "bbbbb"
}
```

#### Time complexity
- `O(n)` as we traverse the string only once using the sliding window.

#### Space complexity
- `O(1)` as the frequency map can contain at most 26 character of the English alphabet.

### Edge test cases
| **Test Case**                   | **Input String** | **`k`** | **Expected Output** | **Explanation**                                                                 |
|---------------------------------|------------------|----------|---------------------|---------------------------------------------------------------------------------|
| **1. Empty String**             | `""`            | `2`      | `0`                 | The string is empty, so the longest substring is `0`.                          |
| **2. Single Character**         | `"a"`           | `0`      | `1`                 | Single character, no replacement needed, result is `1`.                        |
| **3. Single Character**         | `"a"`           | `2`      | `1`                 | Even with `k=2`, the string length is `1`, so the result is `1`.               |
| **4. All Same Characters**      | `"aaaaa"`       | `2`      | `5`                 | No replacements needed, longest substring is the full string.                  |
| **5. No Replacement Allowed**   | `"aab"`         | `0`      | `2`                 | No replacements allowed, longest substring is `"aa"`.                          |
| **6. All Distinct Characters**  | `"abcd"`        | `3`      | `4`                 | Replace `3` characters to make all characters the same (`"aaaa"`).             |
| **7. Mixed Characters**         | `"aababba"`     | `1`      | `4`                 | Replace `1` character to get `"aaaa"` or `"aaab"`.                             |
| **8. Short String**             | `"abcde"`       | `2`      | `3`                 | Replace `2` characters to get longest substring of length `3`.                 |
| **9. Longer Mixed Characters**  | `"ababaccc"`    | `2`      | `5`                 | Replace `2` characters to get `"ababa"` or `"baccc"`.                          |
| **10. Multiple Possibilities**  | `"aabccbb"`     | `2`      | `5`                 | Replace `2` characters to get `"bbbbb"`.                                       |

### Comparison between the two approaches
| **Aspect**                     | **Brute Force Approach**                                           | **Optimal Approach (Sliding Window)**                                      |
|---------------------------------|---------------------------------------------------------------------|-----------------------------------------------------------------------------|
| **Time Complexity**             | O(n^2)                                                              | O(n)                                                                        |
| **Space Complexity**            | O(1) (excluding input storage)                                      | O(k) (for storing character frequencies)                                   |
| **Approach**                    | Try all substrings, check for each if they can be made uniform by replacing at most `k` characters | Use a sliding window to maintain the longest substring where at most `k` characters are different |
| **Implementation Complexity**   | Higher complexity due to checking all substrings                    | Lower complexity, uses a sliding window with a frequency map                |
| **Memory Usage**                | No additional memory usage except for input string                   | Requires a frequency map to track character counts                          |
| **Accuracy**                    | Correct but inefficient, as it checks every possible substring      | Correct and efficient, only keeps track of the current valid window         |
| **Scalability**                 | Poor scalability for larger inputs (`O(n^2)` time complexity)      | Excellent scalability (`O(n)` time complexity)                              |
| **Window Management**           | Not applicable (checks all possible substrings)                    | Uses a sliding window technique to efficiently manage the substring         |
| **Replacements**                | Counts replacements for each substring and checks validity         | Expands the window and shrinks it when necessary to ensure `k` replacements are not exceeded |
| **Best Case Performance**       | O(n^2) even for cases with large substrings                        | O(n) for all cases, handles edge cases efficiently                          |
| **Worst Case Performance**      | O(n^2)                                                              | O(n)                                                                        |
| **Use Case**                    | Suitable for very small inputs or when no optimization is required | Best for large inputs, optimized for both time and space                    |

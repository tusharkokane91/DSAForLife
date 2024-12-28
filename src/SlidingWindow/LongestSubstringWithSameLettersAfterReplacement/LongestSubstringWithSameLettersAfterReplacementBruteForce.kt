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
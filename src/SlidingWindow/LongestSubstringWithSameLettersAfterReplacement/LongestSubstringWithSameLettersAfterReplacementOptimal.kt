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
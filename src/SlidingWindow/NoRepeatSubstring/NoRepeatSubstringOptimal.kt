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
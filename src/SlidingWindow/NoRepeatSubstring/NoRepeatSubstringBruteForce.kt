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
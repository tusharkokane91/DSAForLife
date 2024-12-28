package SlidingWindow.LongestSubstringWithKDistinctCharacters

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
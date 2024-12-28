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
fun getLargestRectangleArea(heights: IntArray): Int {
    var count = 0
    var repeatingNumber = 0
    var maxArea = 0

    for (i in 1..< heights.size) {
        if (heights[i] == heights[i-1]) {
            repeatingNumber = heights[i]
            count++
        } else {
            if (repeatingNumber != 0 && count != 0) maxArea = maxOf(maxArea, (count+1)*repeatingNumber)
            count = 0
            repeatingNumber = 0
        }
    }

    return maxArea
}

fun main() {
    val testCases = listOf(
        intArrayOf(2, 1, 5, 6, 2, 3),      // Expected: 10 (Rectangle formed by heights 5 and 6)
        intArrayOf(2, 4),                  // Expected: 4 (Single largest bar 4)
        intArrayOf(6, 2, 5, 4, 5, 1, 6),  // Expected: 12 (Rectangle formed by heights 5, 4, and 5)
        intArrayOf(1, 2, 3, 4, 5),        // Expected: 9 (Rectangle formed by heights 3, 4, and 5)
        intArrayOf(5, 4, 3, 2, 1),        // Expected: 9 (Rectangle formed by heights 3, 4, and 5)
        intArrayOf(7, 1, 7, 2, 2, 4),     // Expected: 8 (Rectangle formed by height 2 spanning index 3 to 4)
        intArrayOf(1, 1, 1, 1),           // Expected: 4 (All bars of height 1 spanning the full array)
        intArrayOf(1),                    // Expected: 1 (Single bar of height 1)
        intArrayOf(),                     // Expected: 0 (Empty array has no rectangles)
        intArrayOf(0, 0, 0),              // Expected: 0 (All bars of height 0)
        intArrayOf(100, 2, 100),          // Expected: 100 (Single largest bar 100)
        intArrayOf(3, 1, 3, 2, 2),        // Expected: 6 (Rectangle formed by heights 2 spanning index 3 to 4)
        intArrayOf(6, 7, 5, 2, 4, 5, 9, 3) // Expected: 16 (Rectangle formed by heights 5, 2, 4, 5)
    )

    for ((index, heights) in testCases.withIndex()) {
        println("Test case $index: Input: ${heights.joinToString(", ")}")
        println("Output: ${getLargestRectangleArea(heights)}\n")
    }
}


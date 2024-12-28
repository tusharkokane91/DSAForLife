package Stacks.DailyTemperatures

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val n = temperatures.size
    val result = IntArray(n) { 0 }
    val stack = mutableListOf<Int>()

    for (i in temperatures.indices) {
        if (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
            result[i] = i - stack.removeLast()
        }
        stack.add(i)
    }

    return result
}

fun main() {
    // Test cases
    val temperatures1 = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    println(dailyTemperatures(temperatures1).joinToString()) // Output: [1, 1, 4, 2, 1, 1, 0, 0]

    val temperatures2 = intArrayOf(30, 40, 50, 60)
    println(dailyTemperatures(temperatures2).joinToString()) // Output: [1, 1, 1, 0]

    val temperatures3 = intArrayOf(30, 60, 90)
    println(dailyTemperatures(temperatures3).joinToString()) // Output: [1, 1, 0]

    val temperatures4 = intArrayOf(90, 80, 70, 60)
    println(dailyTemperatures(temperatures4).joinToString()) // Output: [0, 0, 0, 0]
}

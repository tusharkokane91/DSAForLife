package SlidingWindow.FruitsIntoBaskets

fun maxFruits(fruits: CharArray): Int {
    if (fruits.isEmpty()) return 0

    var start = 0
    var maxLength = 0
    val fruitCount = mutableMapOf<Char, Int>()

    for (end in fruits.indices) {

        // Expand
        val currentFruit = fruits[end]
        fruitCount[currentFruit] = fruitCount.computeIfAbsent(currentFruit){0} + 1

        // Shrink
        while (fruitCount.size > 2) {
            val startFruit = fruits[start]
            fruitCount[startFruit] = fruitCount[startFruit]!! - 1
            if (fruitCount[startFruit] == 0) {
                fruitCount.remove(startFruit)
            }
            start++
        }

        // Keep track of max length we have encountered so far that matches the condition while we are expanding and
        // shrinking over the array
        maxLength = maxOf(maxLength, end-start+1)
    }

    return maxLength
}

fun main() {
    val fruits = charArrayOf('A', 'B', 'C', 'A', 'C')
    val result = maxFruits(fruits)
    println("Maximum fruits collected (Optimal): $result")
}

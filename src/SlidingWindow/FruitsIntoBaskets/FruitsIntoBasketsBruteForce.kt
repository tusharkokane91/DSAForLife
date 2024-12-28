package SlidingWindow.FruitsIntoBaskets

fun maxFruitsBruteForce(fruits: CharArray): Int {
    var maxLength = 0

    for (start in fruits.indices) {
        for (end in start until fruits.size) {
            /*
              Note:- sliceArray returns an array containing elements from start to end in the given array
             */
            val subArray = fruits.sliceArray(start..end)
            if (subArray.toSet().size <= 2) {
                maxLength = maxOf(maxLength, subArray.size)
            }
        }
    }

    return maxLength
}

fun main() {
    val fruits = charArrayOf('A', 'B', 'C', 'A', 'C')
    val result = maxFruitsBruteForce(fruits)
    println("Maximum fruits collected (Brute Force): $result")
}

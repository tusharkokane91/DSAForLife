package DynamicProgramming.ZeroOneKnapsack

/**
 * Time complexity
 *  - Same as that of tabulation approach.
 *
 * Space complexity
 *  - Since we are using a 1D array of size capacity + 1, space complexity would be O(capacity).
 */
fun knapsackTabulationOptimized(weights: IntArray, values: IntArray, capacity: Int): Int {

    val maxValueForGivenCapacity = IntArray(capacity+1) { 0 }

    for (index in weights.indices) {
        val currentValue = values[index]
        val currentWeight = weights[index]

        for (currentCapacity in capacity downTo currentWeight) {
            maxValueForGivenCapacity[currentCapacity] = maxOf(
                maxValueForGivenCapacity[currentCapacity],
                currentValue + maxValueForGivenCapacity[currentCapacity - currentWeight]
            )
        }
    }

    return maxValueForGivenCapacity[capacity]
}

fun main() {
    val weights = intArrayOf(1, 2, 3, 4)
    val values = intArrayOf(10, 20, 30, 40)
    val capacity = 5

    println("Maximum value: ${knapsackTabulationOptimized(weights, values, capacity)}") // Output: 50
}

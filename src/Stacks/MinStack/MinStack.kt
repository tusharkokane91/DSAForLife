package Stacks.MinStack

class MinStack {

    private val stack = mutableListOf<Int>()
    private val minStack = mutableListOf<Int>()

    fun MinStack() {
        stack.clear()
        minStack.clear()
    }

    fun push(n: Int) {
        if (minStack.isEmpty() || n < minStack.last()) {
            minStack.add(n)
        }
        stack.add(n)
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            val n = stack.removeLast()
            if (n == minStack.last()) {
                minStack.removeLast()
            }
        }
    }

    fun getMin(): Int {
        return if (minStack.isNotEmpty()) return minStack.last() else -1
    }

    fun top(): Int {
        return if (stack.isNotEmpty()) stack.last() else -1
    }
}

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // Output: -3
    minStack.pop()
    println(minStack.top())    // Output: 0
    println(minStack.getMin()) // Output: -2
}

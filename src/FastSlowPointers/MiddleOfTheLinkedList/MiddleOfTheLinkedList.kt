package FastSlowPointers.MiddleOfTheLinkedList

data class Node(var value: Int) {
    var next: Node? = null
}

fun findMiddle(head: Node?): Node? {
    if (head == null) return null

    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}

fun main() {
    // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
    val head = Node(1)
    head.next = Node(2)
    head.next?.next = Node(3)
    head.next?.next?.next = Node(4)
    head.next?.next?.next?.next = Node(5)

    // Test Brute Force
    println(findMiddle(head)?.value) // Output: 3

    // Edge case: Even number of nodes: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    head.next?.next?.next?.next?.next = Node(6)
    println(findMiddle(head)?.value) // Output: 4

    // Edge case: Single node: 1
    val singleNode = Node(1)
    println(findMiddle(singleNode)?.value) // Output: 1

    // Edge case: Null list
    println(findMiddle(null)) // Output: null
}

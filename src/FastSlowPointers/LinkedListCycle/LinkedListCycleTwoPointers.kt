package FastSlowPointers.LinkedListCycle

fun hasCycleTwoPointers(head: Node?): Boolean {
    var slow = head
    var fast = head

    while(fast!= null && fast.next!= null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) return true
    }

    return false
}

fun main() {
    // Test Case 1: List with a cycle
    val node1 = Node(3)
    val node2 = Node(2)
    val node3 = Node(0)
    val node4 = Node(-4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2 // Creates a cycle
    println("Test Case 1 (Cycle exists): ${hasCycleTwoPointers(node1)}") // Expected: true

    // Test Case 2: Single node without a cycle
    val singleNode = Node(1)
    println("Test Case 2 (Single node, no cycle): ${hasCycleTwoPointers(singleNode)}") // Expected: false

    // Test Case 3: Single node with a cycle
    singleNode.next = singleNode // Creates a cycle
    println("Test Case 3 (Single node, cycle exists): ${hasCycleTwoPointers(singleNode)}") // Expected: true

    // Test Case 4: Two nodes without a cycle
    val twoNodes = Node(1)
    twoNodes.next = Node(2)
    println("Test Case 4 (Two nodes, no cycle): ${hasCycleTwoPointers(twoNodes)}") // Expected: false

    // Test Case 5: Two nodes with a cycle
    val nodeA = Node(1)
    val nodeB = Node(2)
    nodeA.next = nodeB
    nodeB.next = nodeA // Creates a cycle
    println("Test Case 5 (Two nodes, cycle exists): ${hasCycleTwoPointers(nodeA)}") // Expected: true

    // Test Case 6: Empty list
    println("Test Case 6 (Empty list): ${hasCycleTwoPointers(null)}") // Expected: false

    // Test Case 7: Long list without a cycle
    val longListHead = Node(1)
    var current = longListHead
    for (i in 2..100) {
        current.next = Node(i)
        current = current.next!!
    }
    println("Test Case 7 (Long list, no cycle): ${hasCycleTwoPointers(longListHead)}") // Expected: false

    // Test Case 8: Long list with a cycle
    val longCycleHead = Node(1)
    var longCycleNode = longCycleHead
    val cycleStartNode = Node(50)
    for (i in 2..100) {
        if (i == 50) {
            longCycleNode.next = cycleStartNode
            longCycleNode = cycleStartNode
        } else {
            longCycleNode.next = Node(i)
            longCycleNode = longCycleNode.next!!
        }
    }
    longCycleNode.next = cycleStartNode // Creates a cycle
    println("Test Case 8 (Long list, cycle exists): ${hasCycleTwoPointers(longCycleHead)}") // Expected: true
}
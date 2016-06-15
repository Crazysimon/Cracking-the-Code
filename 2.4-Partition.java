//Solution 1: Create two different linked list, one for elements less than x, and one for greater than or equal to x. Then iterate the linked list, inserting elements to those two new list. and finally merge two list.

/* Pass in the head of the linked list and the value to partition around. */
LinkedListNode partition(LinkedListNode node, int x){
    LinkedListNode beforeStart = null;
    LinkedListNode beforeEnd = null;
    LinkedListNode afterStart = null;
    LinkedListNode afterEnd = null;
    
    /* partition list */
    while (node != null){
        LinkedListNode next = node.next;
        node.next = null;
        if(node.data < x){
            /*insert node into end of before list*/
            if(beforeStart == null){
                beforeStart = node;
                beforeEnd = beforeStart;
            }else{
                beforeEnd.next = node;
                beforeEnd = node;
            }
        }else{
            /*insert node into end of after list*/
            if(afterStart == null){
                afterStart = node;
                afterEnd = afterStart;
            }else{
                afterEnd.next = node;
                afterEnd = node;
            }
        }
        node = next;
    }
    if (beforeStart == null){
        return afterStart;
    }
    /* merge before list and after list*/
    beforeEnd.next = afterStart;
    return beforeStart;
}



// Solution 2: start a new linked list, greater elements put at tail and smaller elements put in head.
LinkedListNode partition(LinkedListNode node, int x){
    LinkedListNode head = null;
    LinkedListNode tail = null;
    
    while(node != null){
        LinkedListNode next = node.next;
        if(node.data < x){
            node.next = head;
            head = node;
        }else{
            tail.next = node;
            tail = node
        }
        node = next;
    }
    tail. next = null;
    
    return head;
}


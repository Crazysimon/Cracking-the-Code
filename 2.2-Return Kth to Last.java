//Assume that we don't know the length of the linked list.
//Solution 1: Recursive.
//Approach A, don't return the element, but simply printing it.

int printKthToLast(LinkedListNode head, int k){
    if(head == null){
        return 0;
    }
    int index = printKthToLast(head.next, k) +1;
    if(index == k){
        System.out.println(k+"th to last node is " + head.data);
    }
    return index;
}

//Approach B, Create a Wrapper Class.

Class Index{
    public int value = 0;
}

LinkedListNode kthToLast(LinkedListNode head, int k){
    Index idx = new Index();
    return kthToLast(head, k, idx);
}

LinkedListNode kthToLast(LinkedListNode head, int k, Index idx){
    if (head == null){
        rerturn null;
    }
    
    LinkedListNode node = kthTolast(head.next, k, idx);
    idx.value= idx.value + 1;
    if(idx.value == k){
        return head;
    }
    return node;
}



// Solution 2: Iterative (optimal) use p1 & p2 two pointers.O(n) time and O(1) space.

LinkedListNode kthToLast(LinkedListNode head, int k){
    LinkedListNode p1 = head;
    LinkedListNode p2 = head;
    
    for (int i =0; i < k; i++){
        if(p1 == null) return null;
        p1 = p1.next;
    }
    
    while (p1 != null){
        p1 = p1.next;
        p2 = p2.next;
    }
    return p2;
}


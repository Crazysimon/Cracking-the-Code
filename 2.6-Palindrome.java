//Solution 1: Reverse and compare, reverse it and compare the reversed list to the original one. Only actuallu need to compare the first half of the list.

boolean isPalinbrome(LinkedListNode head){
    LinkedListNode reversed = reverseAndClone(head);
    return isEqual(head, reversed);
}

LinkedListNode reverseAndClone(LinkedListNode node){
    LinkedListNode head = null;
    while (node != null){
        LinkedListNode n = new LinkedListNode(node.data);
        n.next = head;
        head = n;
        node = node.next;
    }
    return head;
}

boolean isEqual(LinkedListNode one, LinkedListNode two){
    while(one != null %% two != null){
        if (one.data != two.data){
            return false;
        }
        one = one.next;
        two = two.next;
    }
    return true;
}


//Solution 2: Iterative Approach.
// push the first half of the elements into a stack. If we know the size of linked list, iterate through the first half of the elements to push; If don't know the size, iterate through the linked list using the fast/slow runner.
//Then iterate through the rest of list, at each iterate, we compare the node to the top of the stack.

boolean isPalindrome(LinkedListNode head){
    LinkedListNode fast = head;
    LinkedListNode slow = head;
    
    Stack<Integer> stack = new Stack<Integer>;
    
    /*push elements from first half of linked list onto stack. When fast runner(x2 speed) reaches the end of the linked list, then we know the middle.*/
    while(fast != null && fast.next != null ){
        stack.push(slow.data);
        slow = slow.next;
        fast = fast.next.next;
    }
    
    /* Has odd number of elements, so skip the middle element*/
    if(fast != null){
        slow = slow. next;
    }
    
    while (slow != null){
        int top = stack.pop().intValue();
        
        /* if values are different, then it's not a palindrome*/
        if (top != slow.data){
            return false
        }
        slow = slow.next;
    }
    return true;
}


//Solution 3: Recursive Approach;



/*1. Run through each linked list to get the lengths and the tails.
 *2. Compare the tails, if different, return null (no intersection).
 *3. Set the two pointers to the start of each linked list.
 *4. On the longer list, advance its pointer by difference in lengths.
 *5. Now, traverse on each linked list until the pointers are the same.
 *  ---- takes O(A+B) time, and O(1) additional space, A and B are lengths of two linked list.
 */

LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2){
    if (list1 == null || list2 == null) return null;
    
    /*get the length and tail*/
    Result result1 = getTailAndSize(list1);
    Result result2 = getTailAndSize(list2);
    
    if(result1.tail != result2.tail){
        return null;
    }
    
    /*set pointers to the start of each linked list*/
    LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
    LinkedListNode longer = result1.size < result2.size ? list2 : list1;
    
    /*Advance the pointer for the longer linked list by difference in lengths. */
    longer = getKthNode(longer, Math.abs(result1.size - result2.size));
    
    /*move both pointers until have a collition*/
    while(shorter != longer){
        shorter = shorter.next;
        longer = longer.next;
    }
    return longer;
}

class Result{
    public LinkedListNode tail;
    public int size;
    public Result(LinkedListNode tail, int size){
        this. tail = tail;
        this. size = size;
    }
}


Result getTailAndSize(LinkedListNode list){
    if (list == null) return null;
    
    int size =1;
    LinkedListNode current = list;
    while (current.next!= null){
        size++;
        current = current.next;
    }
    return new Result(current, size);
}


LinkedKistNode getKthNode(LinkedListNode head, int k){
    LinkedListNode current = head;
    while(k>0 &&current!= null){
        current = current.next;
        k--;
    }
    return current;

}
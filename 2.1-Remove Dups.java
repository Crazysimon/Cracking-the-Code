/*
 * 1. track duplicates, simple hash table required.
 * 2. iterate the linked list, add each element to hash table.  When discover a dup, remove the element and continue iterating. 
*/

//takes O(n) time, but need buffer space(hash table).
void deleteDups(LinkedListNode n){
    HashSet<Integer> set = new HashSet<Integer>();
    LinkedListNode previous = null;
    while (n != null){
        if (set.contains(n.data)){
            previous.next=n.next;
        }else{
            set.add(n.data);
            previous = n;
        }
        n = n.next;
    }
}



/*
 * There is no bufffer, iterate with two pointers: the current which iterates through the linked likst; the runner which checks all subsequents nodes for duplicates.
*/

//O(1) Space but O(n^2) running time.

void deleteDups(LinkedListNode head){
    LinkedListNode current =  head;
    while (current != null){
        /*remove all future nodes that have the same value*/
        LinkedListNode runner =  current;
        while(runner.next != null){
            if(runner.next.data == current.data){
                runner.next = runner.next.next;
            }else{
                runner=runner.next;
            }
        }
        currnt = current.next;
    }
}
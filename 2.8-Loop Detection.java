/*1. Create 2 pointers. FastPointer and SlowPointer.
 *2. Move Fastpointer at a rate of 2 steps when Slowpointer at a rate of 1 step.
 *3. When they collide, move slowpointer to the linked list head, keep FastPointer where it is.
 *4. Move two pointers both at a rate of 1 step, and return the noew collision point.
 */

LinkedListNode FindBeginning(LinkedListNode head){
    LinkedListNode fast = head;
    LinkedListNode slow = head;
    
    while(fast != null & fast.next != null){
        slow = slow.next;
        fast = fast.next,next;
        if(slow == fast){ // collision
            break;
        }
    }
    
    /*Error check - no meeting point, and therefore no loop*/
    if (fast == null ||fast.next == null){
        return null;
    }
    
    /*move slow to head, keep fast at the first meeting point.each are k steps from the loop start point. */
    slow =head;
    while(slow!=fast){
        slow = slow.next;
        fast = fast.next;
    }
    //both two pointers now at the start node of the loop.
    return fast;
}
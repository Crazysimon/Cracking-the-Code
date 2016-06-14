//solution is to copy the data from the next node over to the current node, and then to delete the next node;

boolean deleteNode(LinkedListNode n){
    if(n == null || n.next == null){
        return false;
    }
    LinkedListNode next = n.next;
    n.data = next.data;
    n.next = next.next;
    return true;
}

// This problem cannot be solved if the node to be deleted is the last node in the list.
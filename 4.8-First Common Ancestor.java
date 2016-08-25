// Solution 1: With Linkes to Parents, similar solution to 2.7(find intersection of two linked list)

TreeNode commonAncestor(TreeNode p, TreeNode q){
    int delta = depth(p) - depth(q); //get difference in depths.
    TreeNode first = delta > 0 ? q : p; //get shallower node
    TreeNode second = delta > 0 ? p : q; //get deeper node
    second = goUpBy(second, Math.abs(delta)); move deeper node up.
    
    /*Find where paths intersect*/
    
    while(first != second && first != null & second != null){
        first = first.parent;
        second = second .parent;
    }
    return first == null || second == null ? null : first;
    
}

TreeNode goUpBy(TreeNode node, int delta){
    while(delta > 0 && node != null){
        node = node.parent;
        delta --;
    }
    return node;
}

int depth(TreeNode node){
    int depth =0;
    while(node != null){
        node = node.parent;
        depth ++;
    }
    return depth;
}
/*This algorithm will take O(d) time, where d is the depth of the deeper node.*/



// Solution 2: With Links to Parents (Better worst-case Runtime)

TreeNode commonAncestor(TreeNode p, TreeNode q){
    /*check if either node is not in the tree, or if one covers the other*/
    if(!covers(root, p) || !covers(root, q)){
        return null;
    }
    else if (covers(p, q)){
        return p;
    }
    else (covers(q, p)){
        return q;
    }
    
    /*Traverse upwards untill you find the node that covers q.*/
    TreeNode sibling = getSibling(p);
    TreeNode parent = p.parent;
    
    while(!covers(sibling, q)){
        sibling = getSibling(parent);
        parent = parent.parent;
    }
    return parent;
}


boolean covers(TreeNode root, TreeNode p){
    if(root == null) return false;
    if (root == p) return true;
    return covers(root.left, p) ||covers(root.right, p);
}

TreeNode getSilbing(TreeNode node){
    if(node == null || node.parent ==null){
        return null;
    }
    TreeNode parent = node.parent;
    return parent.left == node ? parent.right : parent.left;
}
/*This algorithm takes O(t) time, t is the size of the subtree for the first common ancestor. In worst case, this will be O(n), where n is the number of the nodes.*/


//*Solution 3: WithOut Links to Parent

TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
    /*Error check - One node in the tree*/
    if(!covers(root, p) || !covers(root, q)){
        return null;
    }
    return ancestorHelper(root, p ,q);
}

TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q){
    if(root == null || root == q || root == p){
        return root;
    }
    boolean pIsOnLeft = covers(root.left, p);
    boolean qIsOnLeft = covers(root.left, q);
    if (pIsOnLeft != pIsOnLeft){//on different side;
        return root;
    }
    TreeNode childSide = pIsOnLeft? root.left : root.right;
    return ancestorHelper(childside, p ,q);
}

boolean covers(TreeNode root, TreeNode p){
    if (root == null) return false;
    if (root == p) return true;
    return covers(root.left, p) || covers(root.right, p);
}




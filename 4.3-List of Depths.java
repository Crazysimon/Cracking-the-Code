//Solution 1: pre-order traversal algorithm, where we pass in level + 1 to the next recursive call.

void createLevelLinkedList (TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
    if (root == null){
        return ; // base case;
    }
    LinkedList<TreeNode> list = null;
    if(lists.size() == level){ // level not contained in list.
        list = new LinkedList<TreeNode>();
        /* levels are always traversed in order. So, if this is the first time we've visited level i, we must have seen levels 0 through i - 1. We can
        * therefore safely add the level at the end.*/
        lists.add(list);
    }
    else{
        list = lists.get(level);
    }
    lists.add(root);
    createLevelLinkedList(root.left, lists, level+1);
    createLevelLinkedList(root.right, lists, level+1);
}

ArrayList <LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
    ArrayList <LinkedList<TreeNode>> lists = new ArrayList <LinkedList<TreeNode>>();
    createLevelLinkedList(root, lists, 0);
    return lists;
}


//solution 2: a modification of breadth-first search. we want to iterate through the root first, then level 2 , 3 and so on.
//This means that to get which nodes are on level i, we can simply look at all children of the nodes of level i -1.

ArrayList <LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
    ArrayList <LinkedList<TreeNode>> result = new ArrayList <LinkedList<TreeNode>>();
    /* "visit" the root.*/
    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    if (root != null){
        current.add(root);
    }
    while (current.size() > 0){
        result.add(current); // add prerious level.
        LinkedList<TreeNode> parent = current; //go to next level;
        current = new LinkedList<TreeNode>();
        for (TreeNode parent: parents){
            /*visit the children*/
            if(parent.left != null){
                current.add(parent.left);
            }
            if(parent.right != null){
                current.add(parent.right);
            }
        }
    }
    return result;
}


/* Two solutions both run inO(N) time. but second is more space efficient.
*First solution uses O(logN) recursive calls, each of which adds a new level to the stack, require extra space.

*However, both solutions require returning O(N) data. tge extra O(logN) space usage from the recursive implementation
* is dwarfed by the O(N) data that must be returned. So while thefirst solution may actaully use more data,
* they are equally efficient when it comes to 'big O'. */








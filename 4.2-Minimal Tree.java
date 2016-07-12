//recursively using the createMinimalBST method. this method is passed just a subsection of the array and returns the root of a minimal tree for that array.
/*
1. Insert into the tree the middle element of the array,
2. Insert (into the left subtree) the left subarray elements.
3. Insert (into the right subtree) the right subarray elements.
4. Recurse.
*/

TreeNode createMinimalBST(int array[]){
    return createMinimalBST(array, 0, array.length - 1);
}

TreeNode createMinimalBST(int array[], int start, int end){
    if (end < start){
        return null;
    }
    int mid = (start + end) / 2;
    TreeNode n = new TreeNode(array[mid]);
    n.left = createMinimalBST(array, start, mid -1);
    n.right = createMinimalBST(array, mid +1, end);
    return n;

}
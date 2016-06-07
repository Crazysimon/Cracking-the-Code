//implement the rotation in layers. perform a circular rotation on each layer, top to right, right to bottom......

boolean rotate (int[][] matrix){
    if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
    int n = matrix.lenth;
    
    for (int layer = 0; layer < n/2; layer++ ){
        int first = layer;
        int last = n - 1 - layer;
        for (int i = first; i< last; i++){
            int offset = i - first;
            int top = matrix[first][i]; //save top layer.
            
            //left to top
            matrix[first][i] = matrix[last-offset][first];
            //bottom to left
            matrix[last-offset][first] = matrix[last][last-offset];
            // right to bottom
            matrix[last][last-offset] = matrix][i][last];
            //top(saved) to right
            matrix][i][last] = top;
            
        }
    }
    return true;
}
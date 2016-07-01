//Solution:

void sort(Stack<Integer> s){
    Stack<Integer> r = new Stack<Integer>();
    while(!s.isEmpty()){
        /*insert each element in s sorted order to r*/
        int temp = s.pop();
        while(!r.isEmpty() && r.peek() > temp){
            s.push(r.pop());
        }
        r.push(temp);
    }
    
    /*copy r back to s*/
    while(!r.isEmpty()){
        s.push(r.pop());
    }
}
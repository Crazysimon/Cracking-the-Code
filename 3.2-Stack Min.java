//Solution 1: each node records the what the minimum beneath it.

public class StackWithMin extends Stack<NodeWithMin>{
    
    public void push(int value){
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }
    
    public int min(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE; //error value.
        }
        else{
            return peek().min;
        }
    }
    
}

class NodeWithMin {
    public int value;
    public int min;
    public NodeWithMin(int v, int min){
        value = v;
        this.min = min;
    }
}
/*if we have a large stack, this solution will waste a lot pf space by storing the min on each node.*/


//Solution 2: using an additional stack which keeps track of the mins.

public StackWithMin2 extends Stack<Integer>{
    Stack<Integer> s2;
    public StackWithMin2(){
        s2 = new Stack<Integer>;
    }
    
    public void push(int value){
        if(value <. min()){
            s2.push(value);
        }
        super.push(value);
    }
    
    pinlic Integer pop(){
        int value = super.pop();
        if(value == min()){
            s2.pop();
        }
        return value;
    }
    
    public int min(){
        if(s2.isEmpty()){
            return Integer.MAX_VALUE; //error value.
        }
        else{
            return s2.peek();
        }
    }
    
}
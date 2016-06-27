// Approach 1: Fixed Division. Divide the array in three equal parts. stack 1: [0,n/3); stack 2; [n/3,2n/3); stack 3: [2n/3,n)

class FixedMultiStack{
    private int numberOfStack = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;
    
    public FixedMultiStack(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStack];
        sizes = new int[numberOfstacks];
    }
    
    /*push value to stack*/
    public void push(int stackNum, int value) throws FullStackException{
        if(isFull(stackNum)){
            throws new FullStackException();
        }
        
        /*increment stack pointer and then updaet top value*/
        sizes[stackNum]++;
        values[indexOfTop(stackNumber)] = value;
    }
    
    /*pop (return and remove) item from top stack*/
    public int pop(int stackNum){
        if(inEmpty(stackNum)){
            throw new EmptyStackExeption();
        }
        
        int value = values[indexOfTop(stackNum)]; // get the top
        values[indexOfTop(stackNum)] = 0; //clear                   
        sizes[stackNum] --;
        return value;
    }
    
    /*return top element*/
    public int peek(int stackNum){
        if(inEmpty(stackNum)){
            throw new EmptyStackExeption();
        }
        return values[indexOfTop(stackNum)]; 
    }
    
    /* return if the stack is empty*/
    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }
    
    /*return if the stack is full*/
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }
    
    /*returns index of the top of the stack*/
    private int indesOfTop(int stackNum){
        int offset ＝ stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset +size -1;
    }
    
}




// Approach 2: Flexible Divisions: 
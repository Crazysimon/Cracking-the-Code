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




// Approach 2: Flexible Divisions: design the array to be circular.

public class MultiStack{
    
    /*StackInfo is a simple class that holds a set of data about each stack. It does not hold the actual items in the stack.
    * We could have done this with just a bunch of individual variables, but that is messy and doesn't gain us much*/
    private class StackInfo{
        public int start, size, capacity;
        
        public StackInfo(int start, int capacity){
            this. start = start;
            this. capacity = capacity;
        }
        
        /*check if an index on the full array is within the stack boundaries. the stack can wrap arounf to the start of the array. */
        public boolean isWithinStackCapacity(int index){
            /* If outside of bounds of array, return false*/
            if (index < 0 || index >= values.length) return false;
            
            /*If index wraps around, adjust it*/
            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end;
        }
        
        public int lastCapacityIndex(){
            return adjustIndex(start + capacity -1);
        }
        
        public int lastElementIndex(){
            return adjustIndex(start + size -1);
        }
        
        public boolean isFull(){
            return size == capacity;
        }
        
        public boolean isEmpty(){
            return size == 0;
        }
        
    }
    
    private StackInfo[] info;
    private int[] values;
    
    public multiStack(int numberOfStacks, int defaultSize){
        info = new StackInfo[numberOfStacks];
        for(int i =0; i < numberOfStacks; i++){
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }
        values = new int[numberOfStacks * defaultSize];
    }
    
    /*push value onto stack num, shifting/expanding stacks as necessary. Throws exception if all stacks are full. */
    
    public void push(int stackNum, int value) throws FullStackException{
        if(allStackareFull()){
            throw new FullStackException();
        }
        /*if this stack is full, expand it*/
        StackInfo stack = info[stackNum];
        if(stack.isFull()){
            expand(stackNum);
        }
        
        /*find the index of the top element in the array + 1, and incement the stack pointer.*/
        stack. size ++;
        values[stack.lastElementIndex()] = value;
    }
    
    /*remove value from stack*/
    public int pop (int stackNum) thows Exception{
        StackInfo stack = info[stackNum];
        if(stack.isEmpty()){
            throw new EmptyStackException;
        }
        
        /*remove last element*/
        int value = values[stack.lastElementIndex()];
        values[stack.lastElementIndex()] = 0; //clear item
        stack.size --;
        return value;
    }
    
    /*get top element of stack*/
    public int peek (int stackNum){
        StackInfo stack = info[stackNum];
        return values[stack.lastElementIndex()];
        
    }
    
    /*Shifts item in stack over by one element. If we have available capacity, then we'll end up shrinking the stack by one element.
    If we don't have avaliable capacity, then we'll need to shift the next stack over too. */
    private void shift(int stackNum){
        System.out.println("///Shifting " + stackNum);
        StackInfo stack = info[stackNum];
        
        /*If this stack is at its full capacity, then you need to move the next stack over by one element. this stack can now claim the freed index. */
        if(stack.size >= stack.capacity){
            int nextStack = (stackNum + 1) % info.length;
            shift(nextStack);
            stack.capacity ++;//claim index that next stack lost
        }
        
        /*shift all elements in stack over by one*/
        int index = stack. lastCapacityIndex();
        while(stack.inWithinStackCapacity(index)){
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }
        
        /*adjust stack data*/
        values[stack.start] = 0; // clear item
        stack.start = nextIndex(stact.start); //move start.
        stack.capacity --;  //shrink capacity.
    }
    
    /*expand stack by shifting over other stacks*/
    private void expand(int stackNum){
        shift((stackNum + 1)% info.length);
        info[stackNum].capacity ++;
    }
    
    /*returns the number of items actually present in the stack*/
    public int numberOfElements(){
        int size =0;
        for (StackInfo sd : info){
            size += sd.size;
        }
        return size;
    }
    
    /*returns true if all staks are full*/
    public boolean allStackAreFull(){
        return numberOfElement == values.length;
    }
    
    /*adjust index to be within the range of 0 -> length -1. */
    private int adjustIndex(int index){
        int max = values.length;
        return ((index % max) + max) % max;
    }
    
    /*get index*/
    private int nextIndex(int index){
        return adjustIndex(index + 1);
    }
    
    /* */
       private int previousIndex(int index){
        return adjustIndex(index - 1);
    }
    
}






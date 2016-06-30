// modify peek() and pop() in reverse order.

public class Myqueue<T>{
    Stack<T> stackNewest, stackOldest;
    
    public Myqueue(){
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }
    
    public int size(){
        return stackNewest.size() + stackOldest.size();
    }
    
    public void add(T value){
        /*push onto Newest, which always has the newest elements on top*/
        StackNewest.push(value);
    }
    
    /*move elements from Newest to Oldest. This is usually done so that we can do operations on oldest*/
    private void shiftStacks(){
        if (stackOldest.isEmpty()){
            while(!stackNewest.isEmpty){
                stackOldest.push(stackNewest.pop());
            }
        }
    }
    
    public T peek(){
        shiftStacks(); //Ensure stackOldest has the current elements;
        return stackOldest.peek(); // retrieve the oldest item.
    }
    
    public T remove(){
         shiftStacks(); //Ensure stackOldest has the current elements;
        return stackOldest.pop(); //pop the oldest item.
    }
    
}

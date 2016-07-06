//can be solverd by simple graph traversal(DFS/BFS). This is the implement with BFS.

enum State(Unvisited; Visited; Visiting; )

boolean search(Graph g, Node start, Node end){
    if( start == end) return true;
    
    //operate as Queue
    LinkedList<Node> q = new LinkedList<Node>();
    
    for(Node u :  g.getNodes()){
        u.state = State.Unvisited;
    }
    start.state = State.Visiting;
    q.add(start);
    Node u;
    
    while(!q.isEmpty()){
        u =  q.removeFirst(); // i.e., dequeue()
        if(u != null){
            for(Node v : u.getAdjacent()){
                if(v.state == State.Unvisited){
                    if(v == end){
                        return true;
                    }
                    else{
                        v.state = State.Visiting;
                        q.add(v);
                    }
                }
            }
            u.state = State.Visited;
        }
    }
    return false;
}


// Tradeoff between DFS and BFS
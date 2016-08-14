// Solution 1:
//1. We first added the nodes with no incoming edges.  If the set of projects can be built, there must be some "first" project, and that project cannot have any depedencies. If a project has no dependencies (incoming edges), then we can build it first.
//2. We removed all outging edges from these roots. This is resonable. Once those root projects were built, it doesn't matter if another project depends on them.
//3. After that, we found the nodes that now have no incoming egdes. Using the same logic from step 1 and 2, it's okay if we build these. Now we just repeat the same steps: find the nodes with no dependencies, add them to the build order, remove their outgoing edges, and repeat.
//4. What if there are nodes remaining, but all have dependencies? This means there's no way the build the system. We should return an error.

/*Find a correct build order*/
Project[] findBuilderOrder(String[] projects, String[][] dependencies){
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects(graph.getNodes());
}

/*Build graph, adding the edge (a, b) if b is dependent on a. Assums a pair is listed in "build order". The pair (a, b) in dependencies indicates that b depends on a and a must be build before b.*/
Graph buildGraph(String[] projects, String[][] dependencies){
    Graph graph = new Graph();
    for(String projct : projects){
        graph.createNode(Project);
    }
    for(String[] denpendency : dependencies){
        String first = denpendency[0];
        String second = denpendency[1];
        graph.addEdge(first, second);
    }
    
    return graph;
}

/*Return a list of the projects a correct build order.*/

Project[] orderProjects (ArrayList<Project> projects){
    Project[] order = new Project[projects.size()];
    /*Add "roots" to the build order first.*/
    int endOfList = addNonDenpendent(order, projects, 0);
    
    int toBeProcessed = 0;
    while(toBeProcessed < order.length){
        project current = order[toBeProcessed];
        
        /*we have a circular dependency since there are no remaining projects with zero dependencies*/
        if (current == null){
            return null;
        }
        /*Remove myself as a dependency.*/
        ArrayList<project> children = current.getChildren();
        for (Project child : children){
            child.decrementDependencies();
        }
        
        
        /*Add children that have no one depending on them.*/
        endOfList = addNonDependent(order, children, endOfList);
        toBeProcessed ++;
    }

    return Order;
}

/*A helper function to insert projects with zero dependencies into the order array, starting at index offset*/
int addNonDependent(project[] order, ArrayLsit<project> projects, int offset){
    for (Project project : projects){
        if (project.getNumberDenpendencies == 0){
            order[offset] = project;
            offset ++;
        }
    }
    return offset;
}

public class Graph{
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    
    public Project getOrCreateNode(String name){
        if(!map.containsKey(name)){
            Project node = new Project(name);
            nodes.add(node);
            map.put(name,node);
        }
        return map.get(name);
    }
    
    public void addEdge(String startName, String endName){
        project start = getOrCreateNode(startName);
        project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }
    
    public ArrayList<Project> getNodes(){ return nodes;}
}


public class Project{
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    private String name;
    private int dependencies = 0;
    
    public Project (String n){ name = n;}
    
    public void addNeighbor (project node){
        if(map.containsKey(node.getName())){
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }
    
    public void incrementDependencies(){
        dependencies++;
    }
    
    public void decrementDependencies(){
        dependencies--;
    }
    
    public String getName(){
        return name;
    }
    
    public ArrayList<Project> getChildren {
        return children;
    }
    
    public int getNumberDependencies(){
        return dependencies;
    }
    
}


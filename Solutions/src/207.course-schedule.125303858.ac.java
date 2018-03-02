class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList[] Graph = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            Graph[i] = new ArrayList<Integer>();
        }
        
        //Initialize the graph
        for(int i = 0; i < prerequisites.length; i++){
            Graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        for(int j = 0; j < numCourses; j++){
            if(!dfsHelper(Graph, visited, j))
                return false;
        }
        
        return true;
    }
    
    public boolean dfsHelper(ArrayList[] graph, boolean[] visited, int course){
        
        if(visited[course]) return false;
         
        visited[course] = true;
        
        //Iterate over the particular arraylist of dependecies
        
        for(int i = 0; i < graph[course].size(); i++){
            if(!dfsHelper(graph, visited, (int)graph[course].get(i) ))
                return false;
        }
        
        visited[course] = false; //So that the next iteration can continue;
        
        return true;
        
    }
}

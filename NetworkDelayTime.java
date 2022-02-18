class NetworkDelayTime {
    
    // https://www.youtube.com/watch?v=sD0lLYlGCJE&t=676s&ab_channel=Pepcoding
    
    class Edge{
        int u;
        int v;
        int w;
        
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    class Pair{
        int v;
        int wsf;
        
        public Pair(int v, int wsf){
            this.v = v;
            this.wsf = wsf;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<Edge>[] graph = new ArrayList[n+1];
        
        for(int i = 1; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            
            graph[u].add(new Edge(u, v, w));
        }
        
        int dist = Integer.MAX_VALUE;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.wsf - p2.wsf);
        pq.offer(new Pair(k, 0));
        boolean[] visited = new boolean[n+1];
        
        while(!pq.isEmpty()){
            Pair obj = pq.remove();
            
            
            if(visited[obj.v]){
                continue;
            }
            
            dist = obj.wsf;
            
            visited[obj.v] = true;
            
            for(Edge e: graph[obj.v]){
                if(!visited[e.v]){
                    pq.offer(new Pair(e.v, obj.wsf + e.w));
                }
            }
        }
        
        // checkk if all the nodes are visted, otherwise return -1
        for(int i = 1; i < visited.length; i++){
            if(!visited[i]){
                return -1;
            }
        }
        
        return dist;
    }
}

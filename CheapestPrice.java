class CheapestPrice {
    
    // TLE - but this is the soln
    
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
        int stops;
        int wsf;
        
        public Pair(int v, int stops, int wsf){
            this.v = v;
            this.stops = stops;
            this.wsf = wsf;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Edge>[] graph = new ArrayList[n];
        
        // instantiate graph
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            
            graph[u].add(new Edge(u, v, w));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.wsf -p2.wsf);
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] currStops = new int[n];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(currStops, Integer.MAX_VALUE);
        
        pq.offer(new Pair(src, 0, 0));
        dist[src] = 0;
        currStops[src] = 0;
        
        int currCost = 0;
        
        while(!pq.isEmpty()){
            Pair obj = pq.remove();
            
            currCost = obj.wsf;
            
            if(obj.v == dst){
                return currCost;
            }
            
            if (obj.stops == k + 1) {
                continue;
            }
         
            for(Edge e: graph[obj.v]){
                if(obj.wsf + e.w < dist[obj.v]){
                    pq.offer(new Pair(e.v, obj.stops + 1, obj.wsf + e.w));
                    dist[obj.v] = obj.wsf + e.w;
                }else{
                    pq.offer(new Pair(e.v, obj.stops + 1, obj.wsf + e.w));
                }
                currStops[obj.v] = obj.stops+1;
            }          
        }
        
        return dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
    }
}

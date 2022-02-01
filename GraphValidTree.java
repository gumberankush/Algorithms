class UnionFind{
    
    private int[] parent;
    private int[] size;
    
    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int node){
        if(node == parent[node]){
            return node;
        }
        
        return parent[node] = find(parent[node]);
    }
    
    public boolean union(int u, int v){
        int rootA = find(u);
        int rootB = find(v);
        
        if(rootA == rootB){
            return false;
        }
        
        if(size[rootA] < size[rootB]){
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }else{
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        
        return true;
    }
}

class GraphValidTree {
    
    
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1)
            return false;
        
        UnionFind unionFind = new UnionFind(n);
        
        for(int[] edge: edges){
            int A = edge[0];
            int B = edge[1];
            
            if(!unionFind.union(A, B)){
                return false;
            }
        }
        
        return true;    
    }
}

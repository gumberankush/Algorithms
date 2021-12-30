class SubsetSums{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> list = new ArrayList<>();
        
        solve(arr, 0, 0, N, list);
        Collections.sort(list);
        return list;
    }
    
    public void solve(ArrayList<Integer> arr, int sum, int index, int N, ArrayList<Integer> list){
        if(index == N){
            list.add(sum);
            return;
        }
        
        solve(arr, sum+arr.get(index), index+1, N, list);
        solve(arr, sum, index+1, N, list);
    }
}

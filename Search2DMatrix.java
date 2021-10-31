class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length-1;
        
        // starting from last column of first row
        
        while(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}

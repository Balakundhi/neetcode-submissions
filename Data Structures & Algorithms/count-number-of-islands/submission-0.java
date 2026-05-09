class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == '0') return;

        //sink the island
        grid[row][column] = '0';
        dfs(grid, row+1, column); // go down
        dfs(grid, row-1, column); // go up
        dfs(grid, row, column+1); // go right
        dfs(grid, row, column-1); // go left
    }
}

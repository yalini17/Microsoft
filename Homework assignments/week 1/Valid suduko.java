class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> s = new HashSet();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char number = board[i][j];
                if(number != '.')
                    if(s.contains(number + "_R_"+i)||
                       s.contains(number + "_C_"+j)||
                       s.contains(number + "_B_"+i/3 + "_"+j/3)){
                        return false;
                    }
                else{
                    s.add(number + "_R_" +i);
                    s.add(number + "_C_" +j);
                    s.add(number + "_B_" + i/3 + "_" + j/3);
                }
            }
        }
        return true;
    }
}

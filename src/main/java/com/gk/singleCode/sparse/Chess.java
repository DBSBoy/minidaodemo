package com.gk.singleCode.sparse;



public class Chess {
    int chessArr[][] = new int[9][9];

    public int valueAll(int c[][]){
        int sum = 0;
        for(int i= 0;i<c.length;i++){
            for(int j = 0;j<c[i].length;j++){
                if(c[i][j]!=0){
                    sum++;
                }
            }
        }
        return sum;
    }
}

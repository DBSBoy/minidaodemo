package com.gk.singleCode.sparse;

import org.springframework.beans.factory.annotation.Autowired;

public class sparseArr {
    public static void main(String args[]){
        int sum = 0;
        Chess chess = new Chess();
        int c[][] = chess.chessArr;
        c[1][0] = 6;
        c[2][1] = 7;
        sum = chess.valueAll(c);
        //创建稀疏数组
        int sparse[][] = new int[sum+1][3];
        sparse[0][0] = c.length;
        sparse[0][1] = c[0].length;
        sparse[0][2] = sum;

        int count = 0;
        //遍历原数组找出非零值
        for(int i= 0;i<c.length;i++){
            for(int j = 0;j<c[i].length;j++){
                if(c[i][j]!=0){
                    sparse[count][0] = i;
                    sparse[count][1] = j;
                    sparse[count][2] = c[i][j];
                }
            }
            count++;
        }
        //打印稀疏数组
        for(int i = 0;i<sparse.length;i++)
                System.out.println(sparse[i][0]+"\t"+sparse[i][1]+"\t"+sparse[i][2]+"\t");
                System.out.println();
    }
}

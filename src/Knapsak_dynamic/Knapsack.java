/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Knapsak_dynamic;

public class Knapsack {
    int n=4;
    int W=10;
    int[][] V=new int[n+1][W+1];
    int w[]={5,4,6,3};
    int b[]={15,40,30,50};
    
    
    public Knapsack(){
    
    }
    
    public int maxVal(){
        for(int i=0;i<=n;i++)
            V[i][0]=0;
        for(int j=0;j<=W;j++)
            V[0][j]=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(j-w[i-1]>0){
                    V[i][j]=Math.max(V[i-1][j],b[i-1]+V[i-1][j-w[i-1]]);
                }
                else{
                    V[i][j]=V[i-1][j];
                }
                
            }
        }
        return V[n][W];
            
        
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currency_chhanging_problem;

/**
 *
 * @author DELL
 */
public class currency {
    
    int amount;
    int cr[]={1000,500,100,50,20,10,5,1};
    int count[]=new int[8];
    int total=0;
    
    public currency(int a){
        amount=a;
        
        for(int i=0;i<count.length;i++){
            count[i]=0;
            
        }
    }
    
    public int calc(){
        int ct=0;
        for(int t=0;t<cr.length;t++){
            while(total+cr[t]<=amount){
                total+=cr[t];
                count[t]++;
            }
            
        }
        
        for(int a:count){
            ct+=a;
            
        }
        return ct;
        
    }
    
    
    
}

package Rabin_carp;

import java.util.Scanner;
import java.lang.Math.*;

public class Rabin{
    String txt;
    String pat;
    int h;
    int m,n;
    int pHash=0;
   
    
  
    
    
    public Rabin(){
        Scanner sc=new Scanner(System.in);
        txt=sc.nextLine();
        pat=sc.nextLine();
        m=pat.length();
        n=txt.length();
        
        
        h=(int) Math.pow(10, (m-1));
        
        
    }
    
  
    
    public void patternSearch(){
        int tHash[]=new int[n-m+1];
        tHash[0]=0;
        char P[]=pat.toCharArray();
        char T[]=txt.toCharArray();
        for(int i=1;i<m;i++){
            pHash=((10*pHash)+P[i])%101;
            tHash[0]=((10*tHash[0])+T[i])%101;
            
        }
        
        for(int s=0;s<=n-m;s++){
            if(pHash==tHash[s]){
                System.out.println("ok");
            }
            if(s<n-m){
                tHash[s+1]=(10*(tHash[s]-(T[s]*h))+T[s+m])%101;
            }
            
        }
        
        
       
    }
    
    
    
    
}
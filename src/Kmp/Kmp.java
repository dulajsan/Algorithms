
package Kmp;

import java.util.Scanner;

/**
 * @author Dulaj
 */
public class Kmp {
    static  String a;
    static String b;
    
    public Kmp(){
        Scanner sc=new Scanner(System.in);
        a=sc.nextLine();
        b=sc.nextLine();
        
        
    }
    
    public int search(){
        String t=a;
        String p=b;
        //System.out.println("fdg");
        int lsp[]=cal_table(p);
        int j=0;//Number of chars matched in pattern
        for(int i=0;i<t.length();i++){
            while(j>0 && t.charAt(i)!=p.charAt(j)){
                j=lsp[j-1];
                
            }
            
           
            
            if(t.charAt(i)==p.charAt(j)){
                j++;
               
            }
            if(j==p.length()){
                    return i-(j-1);
                }
        }
        return -1;
        
        
    }
    
    public int[] cal_table(String pt){
       
        int lsp[]=new int[pt.length()];
        int j;
        lsp[0]=0;
        for(int i=1;i<pt.length();i++){
            j=lsp[i-1];
            while(j>0 && pt.charAt(i)!=pt.charAt(j)){
                j=lsp[j-1];
            }
            if(pt.charAt(i)==pt.charAt(j)){
                j++;
            }
            lsp[i]=j;
        }
        return lsp;
        
    }
    
}

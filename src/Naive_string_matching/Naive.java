
package Naive_string_matching;

import java.util.Scanner;
import sun.org.mozilla.javascript.internal.ScriptRuntime;

/**
 *
 * @author Dulaj
 */
public class Naive {
    int n;
    int m;
    String st;
    String pt;
  
    
    Scanner sc=new Scanner(System.in);
    
    public Naive(){  
         System.out.println("Enter a string");
        st=sc.nextLine();
        System.out.println("Enter a pattern");
        pt=sc.nextLine();
        
    }
    
   

   public String bruteForce(){
      // String[] T=st.split("");
       // String[] P=pt.split("");
       
        n=st.length();
        m=pt.length();
        
        for(int i=0;i<=n-m;i++){
            int j=0;
            while(j<m && st.charAt(i+j)==pt.charAt(j)){
                j=j+1;
               // System.out.print("ok");
            }
            
            if(j==m)
                return (Integer.toString(i));

            
        }
        return "There is no substring of st matching pt";
    
}
    
}

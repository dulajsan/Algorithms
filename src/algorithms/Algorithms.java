/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import Naive_string_matching.Naive;
//import currency_chhanging_problem.currency;

/**
 *
 * @author DELL
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //currency c=new currency_chhanging_problem.currency(25);
        //System.out.println(c.calc());
        
        Naive_string_matching.Naive n=new Naive_string_matching.Naive();
        System.out.println(n.bruteForce());
        
    }
    
}

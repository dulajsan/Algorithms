/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.text.html.HTML;

public class ReadFile  {
    
    private static int R=256;
    static Scanner sc=new Scanner(System.in);
       
        public ReadFile() throws IOException{

	try {
		FileReader fileReader = new FileReader(new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\test.txt"));
                BufferedReader br = new BufferedReader(fileReader);
                String line = null;
             
 // 
                while ((line = br.readLine()) != null) {
                    line+=line;
                    

                }
                //System.out.println(word[1]);
                fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}
}
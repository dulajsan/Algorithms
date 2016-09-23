/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;


public class MergeSort {
    private int  array[];
    private int tempMergeArr[];
    private int length;
    
    
    public static void main(String[] args) {
        int[] input={45,23,11,89,77,98,4,28,65,43};
        MergeSort m=new  MergeSort();
        m.sort(input);
        for(int i:input){
            System.out.print(i+" ");
    }
    
    }
    
    public void sort(int inputArray[]){
        this.array=inputArray;
        this.length=inputArray.length;
        this.tempMergeArr=new int[length];
        doMerge(0,length-1);
        
    }
    
    
    public void doMerge(int lowerIndex,int higherIndex){
        if(lowerIndex<higherIndex){
            int middle=lowerIndex+(higherIndex-lowerIndex)/2;
            doMerge(lowerIndex, middle);
            doMerge(middle+1, higherIndex);
            mergeParts(lowerIndex,middle,higherIndex);
        
        }
    }
        
    public void mergeParts(int lowerIndex,int middle,int higherIndex){
        for(int i=lowerIndex;i<=higherIndex;i++){
             tempMergeArr[i]=array[i];
        }
        
        int i=lowerIndex;
        int j=middle+1;
        int k=lowerIndex;
        
        while(i<=middle && j<= higherIndex){
            if(tempMergeArr[i]<=tempMergeArr[j]){
                array[k]=tempMergeArr[i];
                i++;
            }else{
                array[k]=tempMergeArr[j];
                j++;
            }
            k++;
        }
        
        while(i<=middle){
            array[k]=tempMergeArr[i];
            k++;
            i++;
        }
         
    }
            
    
    
    
    
}

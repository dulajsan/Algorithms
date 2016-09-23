
package Knapsak_dynamic;
  
 
public class KnapsackItem implements Comparable<KnapsackItem>{
	int benefit;
	int weight;
        static  KnapsackItem item[];

	public KnapsackItem(int b, int w){
		this.benefit=b;
		this.weight = w;
	}
	public double getUnitWeightBenefit(){
		return benefit/(double)weight;
	}
	@Override
	public int compareTo(KnapsackItem o) {
		// TODO Auto-generated method stub
		double buw  = benefit/(double)weight;
		double obuw = o.benefit/(double)o.weight;
		if (buw < obuw) return -1;
		else if (buw > obuw) return +1;
		return 0;
	}
	public static void sort(KnapsackItem [] knitms){
            KnapsackItem.item=knitms;
            quicksort(0, knitms.length-1);
            
	}
        
        public static void quicksort(int lowerIndex,int higherIndex){
            int i=lowerIndex;
            int j=higherIndex;
            
            KnapsackItem pivot=item[lowerIndex+(higherIndex-lowerIndex)/2];
            
            while(i<=j){
                while(item[i].compareTo(pivot)<0){
                    i++;
                }
                
                while(item[j].compareTo(pivot)>0){
                    j--;
                }
                
                if(i<=j){
                    move(i,j);
                    i++;
                    j--;
                }
                
            }
            
            if(lowerIndex<j)
                quicksort(lowerIndex, j);
            if(i<higherIndex)
                quicksort(i, higherIndex);
        }
        
        public static void move(int i,int j){
            KnapsackItem temp=item[i];
            item[i]=item[j];
            item[j]=temp;
            
        }
        


	
}


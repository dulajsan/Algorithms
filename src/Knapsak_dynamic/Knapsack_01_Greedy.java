
package Knapsak_dynamic;

import static Knapsak_dynamic.KnapsackItem.sort;

/**
 *
 * @author Dulaj
 */
public class Knapsack_01_Greedy {
    private static int W;
    private static int totalW=0;
    private static int totalV=0;
    
    public Knapsack_01_Greedy(int w){
        this.W=w;
    }
    
    public void  findMax(KnapsackItem[] knp){
        for(int i=(knp.length-1);i>=0;i--){
			//System.out.printf("benefit: %2d weight: %2d :: b/w : %4.2f\n", knp[i].benefit, knp[i].weight, knp[i].getUnitWeightBenefit());
                       if((totalW+knp[i].weight)<=W){
                            totalW+=knp[i].weight;
                            totalV+=knp[i].benefit;
                            
                            
                        }
		}
                System.out.println(totalV);
    }
    
    public static void main(String [] args){
                
		KnapsackItem [] knp = { 
				new KnapsackItem(6, 1),
				new KnapsackItem(3, 1),
				new KnapsackItem(10,2),
				new KnapsackItem(5, 3),
				new KnapsackItem(18,4),
				new KnapsackItem(15,5),
				new KnapsackItem(7, 7)};
                //KnapsackItem knpItm=new KnapsackItem(W, W);
		sort(knp);
                new Knapsack_01_Greedy(15).findMax(knp);
                new Knapsack_01_Greedy(18).findMax(knp);
                new Knapsack_01_Greedy(19).findMax(knp);
                new Knapsack_01_Greedy(21).findMax(knp);
                new Knapsack_01_Greedy(23).findMax(knp);
                new Knapsack_01_Greedy(25).findMax(knp);
                
		
	}
            
    
}

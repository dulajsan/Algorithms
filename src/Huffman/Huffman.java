////////////////////////////////Developer: dulaj sanjaya/////////////////////////
///////////////////////////////14001284//////////////////////////////////////////
///////////////////////////////Huffman coding//////////////////////////////////
package Huffman;




public class  Huffman {
    
 
    /////////////////////////////////////////node class implemenattaion/////////////////////////////////////////////////////////////
   public static class Node{
       char element;
       int freq;
       Node left;
       Node right;
       String code="";
       
       public Node(){
           
       }
       
       public Node(int freq,char element){
           this.freq=freq;
           this.element=element;
       }
   }
    ///////////////////////////////////////end of node class///////////////////////////////////////////////////
    
    
    
   
   //////////////////////////////////////////Tree class implementation/////////////////////////////////////////////
   
   public static class Tree implements Comparable<Tree>{
       Node root;
       
       /**join two trees*/
       public Tree(Tree t1,Tree t2){
           root=new Node();
           root.left=t1.root;
           root.right=t2.root;
           root.freq=t1.root.freq+t2.root.freq;
        
       }
       
       /** tree leaf*/
       public Tree(int freq,char element){
           root=new Node(freq,element);
           
       }
       
       /** compare trees*/
       public int compareTo(Tree t){
           if(root.freq<t.root.freq)
               return 1;
           else if(root.freq==t.root.freq)
               return 0;
           else
               return -1;
       }

   } 
   
   /////////////////////////////////////////end of tree clas //////////////////////////////////////////////////////
   
   
   ///////////////////////get code///////////////////////////////////////////////////
   public static String[] getCode(Node root){
       if(root==null)
           return null;
       String codes[]=new String[256];
       assignCode(root,codes);
       return codes;
   }
   
   ////////////////recursively assign codes to leaf nodes////////////////////////////////////////
   public static void assignCode(Node root,String[] codes){
       if(root.left!=null){
           root.left.code=root.code+"0";
           assignCode(root.left, codes);
           
           root.right.code=root.code+"1";
           assignCode(root.right, codes);
           
           
       }
       else{
           codes[(int)root.element]=root.code;
       }
       
   }
   
   
   ////////////////////create huffman tree//////////////////////////////////////////////
   public  static Tree createHuffmanTree(int[] counts){
       //System.out.println(counts[97]);
       Heap <Tree> heap=new Heap<Tree>();
       for(int i=0;i<counts.length;i++){
           if(counts[i]>0)
               heap.add(new Tree(counts[i], (char)i));//leaf node
       }
       
       while(heap.getSize()>1){
           Tree t1=heap.remove();
           Tree t2=heap.remove();
           heap.add(new Tree(t1, t2));
       }
       
       return heap.remove(); //final tree
   }
   
   
   
    
    /////////////////////set frequency of chars//////////////////////////////////////////////
    public static int[] getCharFrequency(String text){
        int counts[]=new int[256];
        for(int i=0;i<text.length();i++){
            counts[(int)text.charAt(i)]++;
        }
        return counts;
    }
    
    
    ///////////////////main method/////////////////////////////////////////////////
    public static void main(String args[]){
       // Scanner sc=new Scanner(System.in);
       // System.out.println("Enter the text");
        //String text="Twinkle, Twinkle, little Star";
        char txt[];
        String text="Twinkle,Twinkle, little Star!\n" +
"How I wonder what you are!\n" +
"Up above the world so high,\n" +
"like a diamond in the sky!";
        text=text.toLowerCase();
        System.out.println(text);
       
        
        int frequency[]=getCharFrequency(text);
        //System.out.println(frequency[65]);
        Tree tree=createHuffmanTree(frequency);//create a huffman tree
        //System.out.println(tree.root.freq);
        String codes[]=getCode(tree.root);
        System.out.println("\n");
        for(int i=0;i<codes.length;i++){
            if(frequency[i]!=0){
                System.out.printf("%-15d%-15s%-15d%-15s\n",i,(char)i+"",frequency[i],codes[i]);
            }
        }
        
        txt=text.toCharArray();
        for(int i=0;i<txt.length;i++){
            System.out.print(codes[(int)txt[i]]);
        }
        
        
       
       
        
        
        
    }
    
    
    
}

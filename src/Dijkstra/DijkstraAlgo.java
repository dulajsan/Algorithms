/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dijkstra;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;


class Node{
    //int distanceFromSource=0;
    String name;
    int distance=0;
    String parent=null;
    //Node parent;
    public Map<Node,Integer> neighbors=new HashMap<>();
    
    Node(String name){
        this.name=name;
    }
    
    
   
}

public class DijkstraAlgo {
    
      List<Node>  nodes=new ArrayList<>();
      List<String> visited=new ArrayList<>();
      List<String> parent=new ArrayList<>();
    
   
    public void dijkstra(){
        List<Node> nodesCopy=new ArrayList<>();
       
        nodesCopy.addAll(nodes);
        while(!nodesCopy.isEmpty()){
            Node min=getMin(nodesCopy);
            visited.add(min.name);
            
            
            Map<Node,Integer> neighbors=min.neighbors;
            for(Map.Entry<Node,Integer> me:neighbors.entrySet()){
                relax(min,me.getKey());
            }
            
            nodesCopy.remove(min);
        }
     
        
        
        
    }
    
    public void relax(Node previous, Node next){
        if(next.distance>previous.distance+previous.neighbors.get(next)){
            next.distance=previous.distance+previous.neighbors.get(next);
            //next.parent=previous.name;
            parent.add(previous.name);
        }
        
    }
    
    
    public void initialize(){
        for (Node node:nodes){
            node.distance=Integer.MAX_VALUE;
            
        }
        
        nodes.get(0).distance=0;

        
    }
    
    private Node getMin(List<Node> nodes){
        int min=Integer.MAX_VALUE;
        int minIndex=0;
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).distance<min){
                min=nodes.get(i).distance;
                minIndex=i;
            }
        }
        
        return nodes.get(minIndex);
        
    }
   
           
    
    
    public void drawGraph(){
        
      
        Node A=new Node("A");
        Node B=new Node("B");
        Node C=new Node("C");
        Node D=new Node("D");
        Node E=new Node("E");
        Node F=new Node("F");
        Node G=new Node("G");
        Node H=new Node("H");
        
        A.neighbors.put(G,9);
        A.neighbors.put(B,2);
        A.neighbors.put(F,8);
        B.neighbors.put(C,1);
        C.neighbors.put(D,5);
        C.neighbors.put(F,4);
        D.neighbors.put(C,1);
        D.neighbors.put(D,2);
        F.neighbors.put(G,2);
        G.neighbors.put(A,2);
        H.neighbors.put(B,5);
        H.neighbors.put(G,3);
        
        
        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);     
        nodes.add(E);
        nodes.add(F);
        nodes.add(G);
        nodes.add(H);
        
        
        
        
    }
    
    public static void main(String[] args) {
        DijkstraAlgo d=new DijkstraAlgo();
        d.drawGraph();
        d.initialize();
        d.dijkstra();
        //d.path();
        for(int i=0;i<d.parent.size();i++){
            System.out.println(d.parent.get(i));
            
        }
    }
    
}

package Graphs;


import java.util.*;

public class Graph {

   private Map<Integer, ArrayList<Integer>> map= new HashMap<>();

   public void  addVertex(Integer vertex){
       if(!map.containsKey(vertex)){
           map.put(vertex, new ArrayList<>());
       }
   }

   public void addEdges(Integer sourceNode, Integer destinationNode){
       if(!map.containsKey(sourceNode)){
           addVertex(sourceNode);
       }
       map.get(sourceNode).add(destinationNode);
   }

   public void getVertexCount(){
       System.out.println("the graph has "+ map.keySet().size()+" vertex");

   }

   public void getEdgeCount(){
       int count=0;
       for (Integer i : map.keySet()){
           count+= map.get(i).size();
       }
       System.out.println("the graph has "+ map.keySet().size()+" edges");

   }

   public void hasVertex(Integer source){
       if(map.containsKey(source)){
           System.out.println("the graph has vertex");
       }
       else{
           System.out.println("the graph does not vertex");
       }
   }

   public Boolean implementBFS(int elementToBeSearched , int[] arr) {
       Queue<Integer> checkQueue = new LinkedList<>();

       ArrayList<Integer> parsed = new ArrayList<>();
               for (int i = 0; i < arr.length; i++) {
                   Integer initialElement= arr[i];
                   if(!parsed.contains(arr[i])){
                       checkQueue.add(initialElement);
                   }
                   System.out.println(" initial ele in queue "+ checkQueue.peek());
                   while (!checkQueue.isEmpty()){
                       Integer k= checkQueue.peek();
                       System.out.println("key "+ k);
                       ArrayList<Integer> v= map.get(k);
                       if(v!=null && !parsed.contains(k)){
                           for (Integer ele : v) {
                               if (!parsed.contains(ele) && !checkQueue.contains(ele)) {
                                   System.out.println("queue"+ ele);
                                   checkQueue.add(ele);
                               }
                           }
                           System.out.println("----- "+ checkQueue.peek());
                       }
                       System.out.println("**********");

                       if (checkQueue.peek() == elementToBeSearched) {
                           return true;
                       }
                       checkQueue.poll();
                   }
               }

            return false;
       }

       public Boolean implementDFS( int elementToBeSearched){
       Stack<Integer> s= new Stack<>();
       ArrayList parsed= new ArrayList();
           for (Integer k : map.keySet()) {
               s.push(k);
               if(!parsed.contains(k)){
                   parsed.add(k);
               }

               while (!s.empty()){
                   Integer topEle= s.pop();
                   if(topEle == elementToBeSearched){
                       return true;
                   }
                   else{
                       map.get(topEle).forEach(v->{
                           if(!parsed.contains(v)){
                               s.push(v);
                               parsed.add(v);
                           }
                       });
                   }
               }
           }
       return false;
       }


   }




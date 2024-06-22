package Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackOperations {
    // order of popping and storing not maintained
    public Map<Integer, Integer> nextBiggerNumber(int[] arr){
        Stack<Integer> stack= new Stack<>();
        Map<Integer, Integer> map= new HashMap<>();
        stack.push(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            int currentElement;
            if(i<arr.length-1){
                currentElement= arr[i+1];
            }
           else{
               currentElement= stack.peek();
               map.put(currentElement,-1);
            }
           if(stack.empty()){
               return map;
           }
            while(!stack.empty() && stack.peek() < currentElement){
                int popped=stack.pop();
                map.put(popped, currentElement);
            }
            stack.push(currentElement);
        }
      return map;
    }


    public ArrayList<Integer> findStockSmallerSpan(int[] arr){
        Stack<Integer> s = new Stack();
        s.push(0);
        int[] b=new int[arr.length+1];
        System.arraycopy(arr,0,b, 1, arr.length);
        b[0]= Integer.MAX_VALUE;
        ArrayList<Integer> result= new ArrayList<>();
        for (int i = 1; i < b.length ; i++) {

            if(s.empty()){
                return result;
            }
           while (!s.empty() && b[s.peek()]< b[i]){

               s.pop();

           }

            result.add(i-1,i-s.peek());
            s.push(i);
        }
        return result;
    }
    public Map<Integer, Integer> findNextBiggerNumber(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack();
        ArrayList<Integer> a = new ArrayList<>();
        int[] b=new int[arr.length+1];
        System.arraycopy(arr,0,b, 1, arr.length);
        b[0]= Integer.MAX_VALUE;
        s.push(0);
        for (int i = 1; i < b.length; i++) {
            if (i== b.length - 1) {
                System.out.println("  hhh"+ s.peek()+ b[i]);
               map.put(b[i],-1 );
            }
            if (s.empty()) {
                return map;
            }
            while (!s.empty() && b[s.peek()] < b[i]) {

                map.put(b[s.pop()],b[i]);

            }
            s.push(i);

        }
        return map;
    }
}


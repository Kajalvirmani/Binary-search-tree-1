package Stack;

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
}
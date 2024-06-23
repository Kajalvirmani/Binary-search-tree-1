package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindPathInGraph {

    private Map<String, ArrayList<String>> graph= new HashMap<>();
    public ArrayList<String> result= new ArrayList<>();
    public void  addVertex(String vertex){
        if(!graph.containsKey(vertex)){
            graph.put(vertex, new ArrayList<>());
        }
    }

    public void addEdges(String sourceNode, String destinationNode){
        if(!graph.containsKey(sourceNode)){
            addVertex(sourceNode);
        }
        graph.get(sourceNode).add(destinationNode);
    }

    public void  findPath( String currentPath, String currentNode, String destinationNode) {
        String validPath;
        if (currentPath.contains(currentNode)) {

            return ;
        }
        if (currentNode == destinationNode) {
            validPath = currentPath + destinationNode;
            result.add(validPath);
            return ;
        }
        ArrayList<String> adjacentNodes= graph.get(currentNode);
        if(adjacentNodes!=null){
            for (String adjacentNode : adjacentNodes) {
                findPath(currentPath + currentNode, adjacentNode, destinationNode);
            }
        }


    }
}

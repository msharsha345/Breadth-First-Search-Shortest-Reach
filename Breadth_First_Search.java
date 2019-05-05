package com.epam.task5;

import java.util.*;

public class Breadth_First_Search {

    public static final int WEIGHT = 6;
    
    private static void findShortestPathsFrom(int startNode, Map<Integer, Set<Integer>> edges) {
        int[] distance = new int[edges.size()];
        for(int i=0;i<distance.length;i++) {
            distance[i] = -1;
        }
        
        Set<Integer> visited = new HashSet<>();
        
        Queue<Integer> q = new LinkedList<>();
        distance[startNode] = 0;
        q.add(startNode);
        while(!q.isEmpty()) {
            int node = q.remove();
            visited.add(node);
            
            for(int neighbor: edges.get(node)) {
                if(!visited.contains(neighbor)) {
                    distance[neighbor] = distance[node] + WEIGHT;
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        
        for(int i=0;i<distance.length;i++) {
            if(i != startNode) {
                System.out.print(distance[i] + " ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        
        int numberOfTestCases = in.nextInt();
        
        for(int i=0;i<numberOfTestCases;i++) {
            Map<Integer, Set<Integer>> edges = new HashMap<>();
            int numberOfNodes = in.nextInt();
            for(int j=0;j<numberOfNodes;j++) {
                edges.put(j, new HashSet<>());
            }
            int numberOfEdges= in.nextInt();
            for(int j=0;j<numberOfEdges;j++) {
                int fromNode = in.nextInt() - 1;
                int toNode = in.nextInt() - 1;
                edges.get(fromNode).add(toNode);
                edges.get(toNode).add(fromNode);
            }
            int startNode = in.nextInt() - 1;
            findShortestPathsFrom(startNode, edges);
        }
        System.out.println();
        in.close();
    }
  
}

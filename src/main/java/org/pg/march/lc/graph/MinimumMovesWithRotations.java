package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/description/
 */
public class MinimumMovesWithRotations {

    private int N;
    private int[][] grid; 
    
    public int minimumMoves(int[][] grid) {
        if (grid == null || grid.length < 2) {
            return -1;
        }
        N = grid.length;
        this.grid = grid;
        Graph graph = new Graph(N * N);
        for (int row = 0; row < N; row++) {
            if (grid[row] == null || grid[row].length != N) {
                throw new IllegalArgumentException("Not a N*N grid");
            }
            for (int col = 0; col < N; col++) {
                buildGraph(graph, row, col, Position.HORIZONTAL);
                buildGraph(graph, row, col, Position.VERTICAL);
            }
        }
        ShortestPath shortestPath = new ShortestPath(graph, new Vertex(getIndex(0, 1), Position.HORIZONTAL));
        Stack<Vertex> path = shortestPath.getPath(new Vertex(getIndex(N-1, N-1), Position.HORIZONTAL));
        printPath(path);
        return shortestPath.getDistanceTo(new Vertex(getIndex(N-1, N-1), Position.HORIZONTAL));
    }
    
    private void printPath(Stack<Vertex> path) {
        while(!path.isEmpty()) {
            Vertex v = path.pop();
            System.out.println(v);
//            if(v.position == Position.HORIZONTAL) {
//                System.out.println("-");
//            }else if(v.position == Position.VERTICAL) {
//                System.out.println("|");
//            }
        }
    }

    private void buildGraph(Graph graph, int row, int col, Position position) {
        if(!isValidPosition(row, col, position)) {
            return;
        }
        Vertex v = new Vertex(getIndex(row, col), position);
        if (position == Position.HORIZONTAL) {
            addIfValid(graph, v, row, col+1, Position.HORIZONTAL);
//            addIfValid(graph, v, row, col-1, Position.HORIZONTAL);
//            addIfValid(graph, v, row-1, col, Position.HORIZONTAL);
            addIfValid(graph, v, row+1, col, Position.HORIZONTAL);
            if (isOpen(row + 1, col)) {
                addIfValid(graph, v, row + 1, col - 1, Position.VERTICAL);
            }
        }else if(position == Position.VERTICAL) {
            addIfValid(graph, v, row+1, col, Position.VERTICAL);
//            addIfValid(graph, v, row-1, col, Position.VERTICAL);
            addIfValid(graph, v, row, col+1, Position.VERTICAL);
//            addIfValid(graph, v, row, col-1, Position.VERTICAL);
            if (isOpen(row, col + 1)) {
                addIfValid(graph, v, row-1, col+1, Position.HORIZONTAL);
            }
        }
    }
    
    private void addIfValid(Graph graph, Vertex v, int row, int col, Position position) {
        if(isValidPosition(row, col, position)) {
            graph.addEdge(v, new Vertex(getIndex(row, col), position));
        }
    }
    
    private int getIndex(int row, int col) {
        return (row * N) + col;
    }

    private boolean isOpen(int row, int col) {
        return (isValid(row, col) && grid[row][col] == 0);
    }
    
    private boolean isValid(int row, int col) {
        return (row >= 0 && row < N && col >= 0 && col < N);
    }
    
    private boolean isValidPosition(int row, int col, Position position) {
        if (!isValid(row, col)) {
            return false;
        }
        if (position == Position.HORIZONTAL) {
            return (isOpen(row, col) && isOpen(row, col-1));
        } else if (position == Position.VERTICAL) {
            return (isOpen(row, col) && isOpen(row-1, col));
        }
        return false;
    }
    

    private static class ShortestPath {

        private Graph graph;
        private boolean[] marked;
        private Vertex[] edgeTo;
        private int[] distTo;

        public ShortestPath(Graph graph, Vertex v) {
            int V = graph.V;
            this.graph = graph;
            marked = new boolean[V];
            edgeTo = new Vertex[V];
            distTo = new int[V];
            for (int i = 0; i < V; i++) {
                distTo[i] = Integer.MAX_VALUE;
            }
            int index = Graph.getIndex(v);
            marked[index] = true;
            distTo[index] = 0;
            Queue<Vertex> queue = new LinkedList<>();
            queue.add(v);
            findShortPath(queue);
        }

        private void findShortPath(Queue<Vertex> queue) {
            while (!queue.isEmpty()) {
                Vertex v = queue.poll();
                int vIndex = Graph.getIndex(v);
                for (Vertex w : graph.adj(v)) {
                    int wIndex = Graph.getIndex(w);
                    if (distTo[wIndex] > distTo[vIndex] + 1) {
                        distTo[wIndex] = distTo[vIndex] + 1;
                        edgeTo[wIndex] = v;
                    }
                    if (!marked[wIndex]) {
                        marked[wIndex] = true;
                        queue.add(w);
                    }
                }
            }
        }

        public int getDistanceTo(Vertex w) {
            int wIndex = Graph.getIndex(w);
            if (edgeTo[wIndex] == null) {
                return -1;
            }
            return distTo[wIndex];
        }
        
        public Stack<Vertex> getPath(Vertex w) {
            Stack<Vertex> path = new Stack<>();
            path.add(w);
            for (Vertex v = w; edgeTo[Graph.getIndex(v)] != null; v = edgeTo[Graph.getIndex(v)]) {
                path.add(edgeTo[Graph.getIndex(v)]);
            }
            
            return path;
        }
    }

    private static class Graph {

        private int V;
        private List<Vertex>[] adj;

        public Graph(int n) {
            this.V = 2 * n;
            this.adj = new List[V];
            for (int i = 0; i < adj.length; i++) {
                this.adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(Vertex v, Vertex w) {
            adj[getIndex(v)].add(w);
        }

        public List<Vertex> adj(Vertex v) {
            return adj[getIndex(v)];
        }

        public static int getIndex(Vertex v) {
            return v.index * 2 + v.position.id;
        }

    }

    private static class Vertex {
        public final int index;
        public final Position position;

        public Vertex(int index, Position position) {
            this.index = index;
            this.position = position;
        }

        @Override
        public String toString() {
            return "Vertex [index=" + index + ", position=" + position + "]";
        }
        
    }

    private enum Position {
        HORIZONTAL(0), VERTICAL(1);

        private int id;

        private Position(int id) {
            this.id = id;
        }
    }
}

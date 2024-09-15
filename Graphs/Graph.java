package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private Stack<Integer> stack;
    private Queue<Integer> queue;
    private char[] sortedArray;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }

        sortedArray = new char[MAX_VERTS];
        stack = new Stack<>();
        queue = new LinkedList<>();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void addDirectedEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    private void resetMatrix() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        resetMatrix();
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;

        while (!queue.isEmpty()) {
            int v1 = queue.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }

        resetMatrix();
    }

    public void mts() {
        vertexList[0].wasVisited = true;
        stack.push(0);

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);

            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                stack.push(v);

                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }

        resetMatrix();
    }

    public void topoSort() {
        int orig_nVerts = nVerts;

        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("Error: Graph has cycles");
                return;
            }

            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }

        System.out.print("Topologically sorted order: ");
        for (int i = 0; i < orig_nVerts; i++) {
            System.out.print(sortedArray[i]);
        }
        System.out.println();
    }

    public int noSuccessors() {
        boolean isEdge;

        for (int row = 0; row < nVerts; row++) {
            isEdge = false;

            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }

            if (!isEdge) {
                return row;
            }
        }

        return -1;
    }

    public void deleteVertex(int delVer) {
        if (delVer != nVerts - 1) {
            for (int i = delVer; i < nVerts; i++) {
                vertexList[i] = vertexList[i + 1];
            }

            for (int row = delVer; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }

            for (int col = 0; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }
        }
        nVerts--;
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }

    public static void main(String[] args) {
        Graph theGraph = new Graph();

        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(0, 2); // AC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(0, 4); // AE
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(1, 3); // BD
        theGraph.addEdge(1, 4); // BE
        theGraph.addEdge(2, 3); // CD
        theGraph.addEdge(2, 4); // CE
        theGraph.addEdge(3, 4); // DE

        System.out.print("Visits DFS: ");
        theGraph.dfs();
        System.out.println();
        System.out.print("Visits BFS: ");
        theGraph.bfs();
        System.out.println();
        System.out.print("MST: ");
        theGraph.mts();
        System.out.println();

        Graph directedGraph = new Graph();

        directedGraph.addVertex('A');
        directedGraph.addVertex('B');
        directedGraph.addVertex('C');
        directedGraph.addVertex('D');
        directedGraph.addVertex('E');
        directedGraph.addVertex('F');
        directedGraph.addVertex('G');
        directedGraph.addVertex('H');

        directedGraph.addDirectedEdge(0, 3); // AD
        directedGraph.addDirectedEdge(0, 4); // AE
        directedGraph.addDirectedEdge(1, 4); // BE
        directedGraph.addDirectedEdge(2, 5); // CF
        directedGraph.addDirectedEdge(3, 6); // DG
        directedGraph.addDirectedEdge(4, 6); // EG
        directedGraph.addDirectedEdge(5, 7); // FH
        directedGraph.addDirectedEdge(6, 7); // GH

        directedGraph.topoSort();
    }
}

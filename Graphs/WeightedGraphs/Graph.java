package Graphs.WeightedGraphs;

public class Graph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private int currentVert;
    private PriorityQ thePQ;
    private int nTree;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INFINITY;
            }
        }
        thePQ = new PriorityQ();
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void mstw() {
        currentVert = 0;

        while (nTree < nVerts - 1) {
            vertexList[currentVert].isInTree = true;
            nTree++;

            for (int i = 0; i < nVerts; i++) {
                if (i == currentVert) {
                    continue;
                }

                if (vertexList[i].isInTree) {
                    continue;
                }

                int distance = adjMat[currentVert][i];
                if (distance == INFINITY) {
                    continue;
                }
                putInPQ(i, distance);
            }

            if (thePQ.size() == 0) {
                System.out.println("GRAPH NOT CONNECTED");
                return;
            }

            Edge theEdge = thePQ.removeMin();
            int sourceVert = theEdge.srcVert;
            currentVert = theEdge.destVert;

            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isInTree = false;
        }
    }

    public void putInPQ(int newVert, int newDist) {
        int queueIndex = thePQ.find(newVert);

        if (queueIndex != -1) {
            Edge tempEdge = thePQ.peekN(queueIndex);
            int oldDist = tempEdge.distance;

            if (oldDist > newDist) {
                thePQ.removeN(queueIndex);
                Edge theEdge = new Edge(currentVert, newVert, newDist);
                thePQ.insert(theEdge);
            }
        } else {
            Edge theEdge = new Edge(currentVert, newVert, newDist);
            thePQ.insert(theEdge);
        }
    }

    public static void main(String[] args) {
        Graph theGraph = new Graph();

        theGraph.addVertex('A'); // 0 (start for mst)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addVertex('F'); // 5

        theGraph.addEdge(0, 1, 6); // AB 6
        theGraph.addEdge(0, 3, 4); // AD 4
        theGraph.addEdge(1, 2, 10); // BC 10
        theGraph.addEdge(1, 3, 7); // BD 7
        theGraph.addEdge(1, 4, 7); // BE 7
        theGraph.addEdge(2, 3, 8); // CD 8
        theGraph.addEdge(2, 4, 5); // CE 5
        theGraph.addEdge(2, 5, 6); // CF 6
        theGraph.addEdge(3, 4, 12); // DE 12
        theGraph.addEdge(4, 5, 7); // EF 7

        System.out.print("Minimum spanning tree: ");
        theGraph.mstw();
        System.out.println();
    }
}

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private class VertexList {

        int vertexNumber;
        List<Integer> vertexNeighbors = new ArrayList<>();
        List<Integer> neighborsDistance = new ArrayList<>();

        VertexList(int argNumber) {
            vertexNumber = argNumber;
        }

        void addNeighbor (int argNumber, int argDistance) {

            vertexNeighbors.add(argNumber);
            neighborsDistance.add(argDistance);

        }

        Integer getDistance (int argVetex) {

            if (!vertexNeighbors.contains(argVetex))
                return null;
            int index = vertexNeighbors.indexOf(argVetex);
            return neighborsDistance.get(index);

        }

        List<Integer> getNeighborsList () {

            return vertexNeighbors;

        }

    }

    private List<VertexList> adjacencyList = new ArrayList<>();
    private int graphSize = 0;

    int addVertex() {

        int addingVertexNumber = adjacencyList.size();
        VertexList addingVertex = new VertexList(addingVertexNumber);
        adjacencyList.add(addingVertex);
        graphSize++;
        return addingVertexNumber;

    }

    void addNeighbor(int vertexNumber, int neighborNumber, int distance) {

        if (vertexNumber >= adjacencyList.size() || neighborNumber >= adjacencyList.size())
            return;
        adjacencyList.get(vertexNumber).addNeighbor(neighborNumber, distance);
        adjacencyList.get(neighborNumber).addNeighbor(vertexNumber, distance);

    }

    void printGraphData() {

        for (VertexList i: adjacencyList) {

            System.out.println("vertex number: " + i.vertexNumber + " neighbors: " + i.vertexNeighbors +
                    " distances: " + i.neighborsDistance);

        }

    }

    Integer getDistance(int firstVertex, int secondVertex) {

        if (firstVertex >= graphSize || secondVertex >= graphSize)
            return null;
        return adjacencyList.get(firstVertex).getDistance(secondVertex);

    }

    int getGraphSize() {

        return graphSize;

    }

    List<Integer> getNeighborsList (int vertexNumber) {

        if (vertexNumber >= graphSize)
            return null;
        return adjacencyList.get(vertexNumber).getNeighborsList();

    }

}

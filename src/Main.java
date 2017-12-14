import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addNeighbor(0, 1, 7);
        graph.addNeighbor(0, 2, 9);
        graph.addNeighbor(0, 5, 14);
        graph.addNeighbor(1, 2, 10);
        graph.addNeighbor(1, 3, 15);
        graph.addNeighbor(2, 3, 11);
        graph.addNeighbor(2, 5, 2);
        graph.addNeighbor(3, 4, 6);
        graph.addNeighbor(4, 5, 9);

        Results results = Algorithms.widthSearch(graph, 0, 3);

        System.out.println("width search results: \n");
        System.out.println("previous vertices array: " + Arrays.toString(results.previousVertices));
        System.out.println("path length array: " + Arrays.toString(results.pathLength));
        System.out.println("finded way: " + results.findedWay);
        System.out.println("finded way length = " + results.findedLenght + "\n------------------------\n");

        results = Algorithms.depthSearch(graph, 0, 3);

        System.out.println("depth search results: \n");
        System.out.println("previous vertices array: " + Arrays.toString(results.previousVertices));
        System.out.println("path length array: " + Arrays.toString(results.pathLength));
        System.out.println("finded way: " + results.findedWay);
        System.out.println("finded way length = " + results.findedLenght + "\n------------------------\n");

        results = Algorithms.dijkstraAlgorithm(graph, 0, 3);

        System.out.println("Dijkstra algorithm results: \n");
        System.out.println("previous vertices array: " + Arrays.toString(results.previousVertices));
        System.out.println("path length array: " + Arrays.toString(results.pathLength));
        System.out.println("finded way: " + results.findedWay);
        System.out.println("finded way length = " + results.findedLenght + "\n------------------------\n");

    }

}

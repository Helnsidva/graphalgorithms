import java.util.*;

public class Algorithms {

    static Results widthSearch (Graph graph, int firstVertex, int secondVertex) {

        if (graph == null)
            return null;

        int graphSize = graph.getGraphSize();
        int[] passedVertices = new int[graphSize];
        int[] pathLength = new int[graphSize];
        int[] previousVertices = new int[graphSize];

        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(firstVertex);
        passedVertices[firstVertex] = 1;

        while (!queue.isEmpty()) {

            int currentVertex = queue.poll();
            List<Integer> neighborsList = graph.getNeighborsList(currentVertex);
            for (int i: neighborsList) {

                if (passedVertices[i] == 0) {

                    passedVertices[i] = 1;
                    queue.add(i);
                    pathLength[i] = pathLength[currentVertex] + 1;
                    previousVertices[i] = currentVertex;

                }

            }

        }

        List<Integer> searchingPath = new ArrayList<>();
        searchingPath.add(secondVertex);
        int i = secondVertex;
        while(i != firstVertex) {

            searchingPath.add(previousVertices[i]);
            i = previousVertices[i];

        }

        return new Results(previousVertices, pathLength, searchingPath, pathLength[secondVertex]);

    }

    static Results depthSearch (Graph graph, int firstVertex, int secondVertex) {

        if (graph == null)
            return null;

        int graphSize = graph.getGraphSize();
        int[] passedVertices = new int[graphSize];
        int[] pathLength = new int[graphSize];
        int[] previousVertices = new int[graphSize];

        recursiveDepthSearch(graph, firstVertex, passedVertices, pathLength, previousVertices);

        List<Integer> searchingPath = new ArrayList<>();
        searchingPath.add(secondVertex);
        int i = secondVertex;
        while(i != firstVertex) {

            searchingPath.add(previousVertices[i]);
            i = previousVertices[i];

        }

        return new Results(previousVertices, pathLength, searchingPath, pathLength[secondVertex]);

    }

    static private void recursiveDepthSearch(Graph graph, int firstVertex, int[] passedVertices,
                              int[] pathLength, int[] previousVertices) {

        passedVertices[firstVertex] = 1;
        List<Integer> neighborsList = graph.getNeighborsList(firstVertex);

        for (int i: neighborsList) {

            if (passedVertices[i] == 0) {

                previousVertices[i] = firstVertex;
                pathLength[i] = pathLength[firstVertex] + 1;
                recursiveDepthSearch(graph, i, passedVertices, pathLength, previousVertices);

            }

        }

    }

    static Results dijkstraAlgorithm (Graph graph, int firstVertex, int secondVertex) {

        if (graph == null)
            return null;

        final int INFINITY = 10000;

        int graphSize = graph.getGraphSize();
        int[] pathLength = new int[graphSize];
        int[] previousVertices = new int[graphSize];

        for(int i = 0; i < graphSize; i++) {
            pathLength[i] = INFINITY;
        }

        pathLength[firstVertex] = 0;

        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(firstVertex);

        while (!queue.isEmpty()) {

            int currentVertex = queue.poll();
            List<Integer> neighborsList = graph.getNeighborsList(currentVertex);
            for (int i: neighborsList) {

                if (pathLength[i] > pathLength[currentVertex] + graph.getDistance(currentVertex, i)) {

                    pathLength[i] = pathLength[currentVertex] + graph.getDistance(currentVertex, i);
                    previousVertices[i] = currentVertex;
                    queue.add(i);

                }

            }

        }

        List<Integer> searchingPath = new ArrayList<>();
        searchingPath.add(secondVertex);
        int i = secondVertex;
        while(i != firstVertex) {

            searchingPath.add(previousVertices[i]);
            i = previousVertices[i];

        }

        return new Results(previousVertices, pathLength, searchingPath, pathLength[secondVertex]);

    }

}

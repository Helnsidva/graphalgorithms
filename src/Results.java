import java.util.List;

public class Results {

    int[] previousVertices;
    int[] pathLength;
    List<Integer> findedWay;
    int findedLenght;

    Results (int[] previousVertices, int[] pathLength, List<Integer> findedWay, int findedLength) {

        this.previousVertices = previousVertices;
        this.pathLength = pathLength;
        this.findedWay = findedWay;
        this.findedLenght = findedLength;

    }

}

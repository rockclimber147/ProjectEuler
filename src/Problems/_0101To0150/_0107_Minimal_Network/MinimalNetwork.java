package Problems._0101To0150._0107_Minimal_Network;

import Helpers.FileHelper;
import Stats.RunInfo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimalNetwork {

    private static class Edge {
        int cost;
        int nodeIndex;
        int parentIndex;

        public Edge(int cost, int nodeIndex, int parentIndex) {
            this.cost = cost;
            this.nodeIndex = nodeIndex;
            this.parentIndex = parentIndex;
        }
    }
    private static final String filePath = "src/Problems/_0101To0150/_0107_Minimal_Network/network.txt";
    public static void solution() {
        Integer[][] adjacencyMatrix = FileHelper.readAdjacencyMatrixFromFile(filePath, "\n", ",");
        int totalWeight = totalWeight(adjacencyMatrix);
        int minWeight = minSpanningTreeWeightPrimm(adjacencyMatrix);
        System.out.println(totalWeight - minWeight);
    }

    private static int totalWeight(Integer[][] adjacency) {
        int total = 0;
        for (int i = 1; i < adjacency.length; i++) {
            for (int j = 0; j < i; j++) {
                if (adjacency[i][j] != null) total += adjacency[i][j];
            }
        }
        return total;
    }

    public static int minSpanningTreeWeightPrimm(Integer[][] adjacency) {
        boolean[] visited = new boolean[adjacency.length];
        int min_weight = 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        minHeap.add(new Edge(0, 0, -1));

        while (!minHeap.isEmpty()) {
            Edge top = minHeap.poll();

            if (visited[top.nodeIndex]) continue;
            visited[top.nodeIndex] = true;

            if (top.parentIndex >= 0) {
                min_weight += top.cost;
            }

            for (int i = 0; i < adjacency.length; i++) {
                Integer cost = adjacency[top.nodeIndex][i];
                if (!visited[i] && cost != null) {
                    minHeap.add(new Edge(cost, i, top.nodeIndex));
                }
            }
        }

        return min_weight;
    }

    public static void main(String[] args) {
        RunInfo.showRuntimeMs(MinimalNetwork::solution);
    }
}

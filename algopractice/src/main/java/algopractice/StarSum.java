package algopractice;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class StarSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = 6;
		int[] nodesFrom = { 0, 1, 1, 3, 3, 3 };
		int[] nodesTo = { 1, 2, 3, 4, 5, 6 };
		int[] nodesValue = { 1, 2, 3, 4, 10, -10, -20 };
		int k = 1;

		Graph[] graphNodes = new Graph[n+1];
		Integer maxValue = null;

		for (int i = 0; i < n; i++) {
			if (graphNodes[nodesFrom[i]] == null)
				graphNodes[nodesFrom[i]] = new Graph(nodesValue[nodesFrom[i]], k);
			if (graphNodes[nodesTo[i]] == null)
				graphNodes[nodesTo[i]] = new Graph(nodesValue[nodesTo[i]], k);
			maxValue = graphNodes[nodesFrom[i]].addNodes(nodesValue[nodesTo[i]], maxValue);
			maxValue = graphNodes[nodesTo[i]].addNodes(nodesValue[nodesFrom[i]], maxValue);
		}
		System.out.println("Max " + k + " Star value is : " + maxValue);

	}

	private static class Graph {
		private Queue<Integer> adjoiningNodes;
		private Integer k;
		private Integer kSum;

		public Graph(int node, int k) {
			this.adjoiningNodes = new PriorityQueue<>();
			this.k = k;
			this.kSum = node;

		}

		public Integer addNodes(Integer adjoiningNode, Integer maxValue) {
			if (k == 0) {
				if (maxValue == null || kSum > maxValue)
					return kSum;
				else
					return maxValue;
			}
			else if (adjoiningNodes.size() < k) {
				adjoiningNodes.add(adjoiningNode);
				kSum = kSum + adjoiningNode;
			} else if (k != 0 && adjoiningNodes.size() == k) {
				int lowestValue = adjoiningNodes.poll();
				adjoiningNodes.add(adjoiningNode);
				kSum = kSum - lowestValue + adjoiningNode;
			}
			if (adjoiningNodes.size() == k && (maxValue == null || kSum > maxValue))
				return kSum;
			return maxValue;

		}
	}
}

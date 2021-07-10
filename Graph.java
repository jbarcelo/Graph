import java.util.LinkedList;

class Graph {
	static final int NONODES = 6; //number of nodes
	public static void main(String[] args) {
		// We use and adjacency matrix as a trivial implementation of a graph. 
		// This is not optimum in any way, but it is not the goal of this exercise to implement a graph.
		boolean adjacencyMatrix[][] = new boolean[NONODES][NONODES];
		adjacencyMatrix[0][1]=true; adjacencyMatrix[1][0]=true; // 0 and 1 are neighbors
		adjacencyMatrix[0][2]=true; adjacencyMatrix[2][0]=true; // 0 and 2 are neighbors
		adjacencyMatrix[1][3]=true; adjacencyMatrix[3][1]=true; // 1 and 3 are neighbors
		adjacencyMatrix[2][3]=true; adjacencyMatrix[3][2]=true; // 2 and 3 are neighbors
		adjacencyMatrix[3][4]=true; adjacencyMatrix[4][3]=true; // 3 and 4 are neighbors
		adjacencyMatrix[4][5]=true; adjacencyMatrix[5][4]=true; // 4 and 5 are neighbors

		int newNeighbors=1; //the root is the only new neighbor
		int neighborsChecked=0; //we haven't checked for neighbors of any node yet
		int distance = 1; // in the first iteration we'll look for nodes at distance 1
		LinkedList<Integer> neighbors = new LinkedList<Integer>(); // data structure to store the neighbors
		neighbors.add(0); //this is the root, the starting point

		while (newNeighbors>0){
			System.out.println("------------------------------");
			System.out.println("Looking for neighbors at distance: " + distance);
			//the number of nodes to check in this iteration
			int nodesToCheck = newNeighbors;
			//the number of nodes to check in the next iteration
			newNeighbors = 0;
			for (int i=0; i<nodesToCheck; i++){
				//Integer neighbor = neighborsIterator.next();
				Integer neighbor = neighbors.get(neighborsChecked+i);
				System.out.println("Looking for neighbors of node " + neighbor);
				for (Integer j = 0; j < NONODES; j++){
					if (adjacencyMatrix[neighbor][j]){
						System.out.println("Node " + j + " is adjacent");
						if (!neighbors.contains(j)){
							System.out.println("Node " + j + " is not in our list. We add it.");
							System.out.println("At this point we should verify if the new node satisfied the search condition.");
							neighbors.add(j);
							newNeighbors++;
						}
					}
				}
			}
			neighborsChecked+=nodesToCheck;
			distance++;
			System.out.println("newNeighbors found: " + newNeighbors);
		}

	}
}

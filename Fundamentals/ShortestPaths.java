//*******************
//Italo Panta
//COSC 2336-01
//Instructor: Dr.Doershuk
//Programming Assignment 10
//Due: 4/24/2018
//Submitted: 4/24/2018
//This program shows the paths taken between each vertices
//*******************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ShortestPaths {
	public static void main(String[] args) throws FileNotFoundException {
			 
		System.out.print("Enter a file name: ");
		Scanner InputFile = new Scanner(System.in);
		String FileName = InputFile.nextLine();
		Scanner FilePath = new Scanner(new File(FileName));
		int numberOfVertices = FilePath.nextInt();
		FilePath.nextLine();
		  
		ArrayList<WeightedEdge> Edges = new ArrayList<>();
		while(FilePath.hasNextLine()) {
			String NextPath = FilePath.nextLine();
			String[] a = NextPath.split(",");
			String[] b = NextPath.split("\\|");
			System.out.print("Enter two vertices (integer indexes): ");
			Scanner VerticePath = new Scanner(NextPath);
			
			while(VerticePath.hasNext()) { 
				int u = VerticePath.nextInt();
				int v = VerticePath.nextInt();
				int weight = VerticePath.nextInt();
				Edges.add(new WeightedEdge(u, v, weight));
				Edges.add(new WeightedEdge(v, u, weight));
			}
			VerticePath.close();
		}
		
		System.out.println("The number of vertices is " + numberOfVertices);
		ArrayList<Integer> Vertices = new ArrayList<>();
		  
		for (int i = 0; i < numberOfVertices; i++) {
			Vertices.add(i);
		  }
		
		WeightedGraph<Integer> graph = new WeightedGraph(Edges, Vertices);
		for (int u = 0; u < numberOfVertices; u++) {
			System.out.print("Vertex " + graph.getVertex(u) + ":");
			for (Integer v : graph.getNeighbors(u))
				System.out.print("(" + u + "," + v + ")");
		}
		FilePath.close();
	}
}
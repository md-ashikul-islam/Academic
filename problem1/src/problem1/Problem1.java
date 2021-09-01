
package problem1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Problem1 {

    
    public static void main(String[] args) {
        try {
            System.out.println("--------------------Problem 1--------------------");
            //change the file directory
            File file = new File("C:\\Users\\RHAPSODY\\Desktop\\CSE221 Lab 3\\problem1.txt");
            Scanner sc = new Scanner(file);
            String s = sc.nextLine();
            String[] StringArray = s.split(" ");
            int vertices = Integer.parseInt(StringArray[0]);
            int connections = Integer.parseInt(StringArray[1]);
            int location = Integer.parseInt(StringArray[2]);
            int mission = Integer.parseInt(StringArray[3]);
            ArrayList<ArrayList<Object>> graph = adjencylist_1(sc, vertices, connections);
            System.out.println("Number of marker required");
            for (int i = 0; i < mission; i++) {
                String[] StringArray1 = sc.nextLine().split(" ");
                // here we are doing minius one in the next line because the given inputs are from 1
                int source1 = Integer.parseInt(StringArray1[0]) - 1;
                int destination1 = Integer.parseInt(StringArray1[1]) - 1;
                int[] dj = dijkstra(graph, source1, vertices);
                if (parent[location] < 0) {
                    System.out.println("Be seeing ya, John");
                } else {
                    System.out.println("Case " + (i + 1) + " : " + dj[destination1]);
                }
            }

        } catch (FileNotFoundException | NumberFormatException e) {
        }
    }
    //2d array to store the weights of the edges from one vertex to another.
    static int[][] w;
    static int parent[];

    //basic dijkstra for problem 1

    static int[] dijkstra(ArrayList<ArrayList<Object>> list, int s, int vertices) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int distance[] = new int[vertices];
        parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = 10000000;
            parent[i] = -1;
            q.add(i);
        }
        distance[s] = 0;
        while (q.isEmpty() == false) {
            int u = q.poll();
            for (int p = 0; p < list.get(u).size(); ++p) {
                int temp_distance = distance[u] + w[u][(int) list.get(u).get(p)];
                if (temp_distance < distance[(int) list.get(u).get(p)]) {
                    distance[(int) list.get(u).get(p)] = temp_distance;
                    parent[(int) list.get(u).get(p)] = u;
                }
            }
        }
        return distance;
    }

    static ArrayList<ArrayList<Object>> adjencylist_1(Scanner sc, int vertices, int connections) {
        ArrayList<ArrayList<Object>> List1 = new ArrayList<>();
        w = new int[vertices][connections];
        for (int i = 0; i < vertices; ++i) {
            ArrayList<Object> babylist = new ArrayList<Object>();
            List1.add(babylist);
        }
        for (int i = 0; i < connections; i++) {
            String[] StringArray;
            String s = sc.nextLine();
            StringArray = s.split(" ");
            //minusing one because in the sample data is given from 1 as starting
            int vertex = Integer.parseInt(StringArray[0]) - 1;
            int connect = Integer.parseInt(StringArray[1]) - 1;
            int weight = Integer.parseInt(StringArray[2]);
            //inserting the weight in their correct vertex
            w[vertex][connect] = weight;
            List1.get(vertex).add(connect);
        }
        return List1;
    }
}

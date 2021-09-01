package problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;


public class Problem2 {
    
    public static void main(String[] args) {
        try {
            System.out.println("--------------------Problem 2--------------------");
            //please change directory to a correct path
            File file1 = new File("C:\\Users\\RHAPSODY\\Desktop\\CSE221 Lab 3\\problem2.txt");
            Scanner prob2 = new Scanner(file1);
            int vertices1 = Integer.parseInt(prob2.nextLine());
            int connections1 = Integer.parseInt(prob2.nextLine());
            //next line of the code is not dynamic.just did it for better visualization                
            String[] areas = {"Mouchak", "Panthapath", "Rampura", "Shahbag", "Dhanmondi", "Lalmatia", "Badda", "Hatirjheel", "Nilkhet", "TSC", "Dhaka University", "BUET"};
            ArrayList<ArrayList<Object>> graph = adjencylist(prob2, vertices1, connections1);
            int source = Integer.parseInt(prob2.nextLine());
            int destination = Integer.parseInt(prob2.nextLine());

            //reading damaged roads.or yellow vertices
            String sc1 = prob2.nextLine();
            String[] sc2 = sc1.split(",");

            //using linkedlist to store the yellow vertices. 
            //could have done with array but took linked list for better approach
            LinkedList<Integer> damaged = new LinkedList<Integer>();
            for (String i : sc2) {
                damaged.add(Integer.parseInt(i));
            }

            int[] dj = dijkstra(graph, source, vertices1, damaged);

            //we have to find the route.easiest way is to find all the parents from destination
            //firstly we have to find the element of destination then that element will be index.
            //so we are getting the route in reverse order. we could have done string concatenation.
            //but i took stack..as its Lifo.but could have easily done with concatenation.
            //string concatenation O(n^2) , Stack is O(1)
            Stack<Integer> temp = new Stack<Integer>();
            temp.push(destination);
            int count = 1;
            int element = destination;
            while (element != source) {
                element = parent[element];
                temp.push(element);
                count++;
            }

            //printing outputs
            System.out.print("Route");
            for (int i = 0; i < count; i++) {
                int area = temp.pop();
                System.out.print(" --> " + areas[area] + "(" + area + ")");
            }
            System.out.println();
            System.out.println("Cost : " + dj[destination]);

        } catch (FileNotFoundException | NumberFormatException e) {
        }
    }
    static int[][] w;
    static int parent[];

    static int[] dijkstra(ArrayList<ArrayList<Object>> list, int s, int vertices, LinkedList<Integer> damaged) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int distance[] = new int[vertices];
        parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = 1000000000;
            parent[i] = -1;
            //avoiding yellow vertex
            if (damaged.contains(i) == false) {
                q.add(i);
            }
        }
        distance[s] = 0;
        while (q.isEmpty() == false) {
            int u = q.poll();
            for (int p = 0; p < list.get(u).size(); ++p) {
                //avoiding yellow vertex
                if (damaged.contains((int) list.get(u).get(p)) == false) {
                    int temp_distance = distance[u] + w[u][(int) list.get(u).get(p)];
                    if (temp_distance < distance[(int) list.get(u).get(p)]) {
                        distance[(int) list.get(u).get(p)] = temp_distance;
                        parent[(int) list.get(u).get(p)] = u;
                    }
                }
            }
        }
        return distance;
    }

    static ArrayList<ArrayList<Object>> adjencylist(Scanner sc, int vertices, int connections) {
        ArrayList<ArrayList<Object>> List1 = new ArrayList<>();
        w = new int[vertices][connections];
        for (int i = 0; i < vertices; ++i) {
            ArrayList<Object> babylist = new ArrayList<Object>();
            List1.add(babylist);
        }
        for (int i = 0; i < connections; i++) {
            String[] StringArray;
            String s = sc.nextLine();
            StringArray = s.split(",");
            int vertex = Integer.parseInt(StringArray[0]);
            int connect = Integer.parseInt(StringArray[1]);
            int weight = Integer.parseInt(StringArray[2]);
            w[vertex][connect] = weight;
            List1.get(vertex).add(connect);
        }
        return List1;
    }
}

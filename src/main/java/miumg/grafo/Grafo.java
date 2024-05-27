import java.util.*;

public class Grafo {
    
    public static void dijkstra(int[][] graph, int source, int numVertices) {
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        
        // inicia las distancias hasta el valor max
        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        // todas las distancias valen 0 hasta cambiarlas
        dist[source] = 0;
        
        // crea una cola de prioridad
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        pq.offer(source);
        
        while (!pq.isEmpty()) {
            int current = pq.poll();
            
            // si ya paso por ahi lo salta
            if (visited[current]) {
                continue;
            }
            
            // lo marca como visitado
            visited[current] = true;
            
            // verifica los vertices a los lados
            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                if (!visited[neighbor] && graph[current][neighbor] != 0) {
                    int newDistance = dist[current] + graph[current][neighbor];
                    
                    // Update distance if shorter path found
                    if (newDistance < dist[neighbor]) {
                        dist[neighbor] = newDistance;
                        pq.offer(neighbor);
                    }
                }
            }
        }
        
        // imprime las distancias
        System.out.println("la distancia mas corta " + source);
        for (int i = 0; i < numVertices; i++) {
            System.out.println("distancia de " + source + " hasta " + i + " es " + dist[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantVertices = 0;
        
        System.out.println("Ingresa la cantidad de vertices: ");
        cantVertices = sc.nextInt();
        
        int[][] grafo = new int[cantVertices][cantVertices];
        
        for (int i = 0; i < cantVertices; i++) {
            for (int j = 0; j < cantVertices; j++) {
                System.out.print("Ingrese el peso de la Vertice [" + (i + 1) + " , " + (j + 1) + "] : \n");
                int arista = sc.nextInt();
                grafo[i][j] = arista;
            }
        }
        
        System.out.println("Grafo:");
        for (int i = 0; i < cantVertices; i++) {
            for (int j = 0; j < cantVertices; j++) {
                System.out.print(grafo[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.print("Ingrese el vértice fuente: ");
        int source = sc.nextInt();
        
        dijkstra(grafo, source - 1, cantVertices);
        sc.close();
    }
}

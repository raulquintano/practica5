package util;
import java.util.*;

public class Operaciones {

    public class Graph<V>{
        //Lista de adyacencia.
        private Map<V, Set<V>> adjacencyList = new HashMap<>();
        Set <V> conjuntoVertices = new HashSet<>();

        /*
         * Método que añade el vértice en función si lo tiene o no la lista de adyacencia, de manera que nunca habrá vertices duplicados.
         */
        
        public boolean addVertex(V v){

            if(adjacencyList.containsValue(v))
            {
                return false;                
            }
            else{
                adjacencyList.put(v, conjuntoVertices);
                return true;
            }           
        }

        /*
         * Método para agregar una arista entre los vertices en el grafo.
         */
        public boolean addEdge(V v1, V v2){

            if(adjacencyList.containsKey(v1))
            {
                if(adjacencyList.containsKey(v2))
                {
                    if(adjacencyList.get(v1).contains(v2))
                    {
                        return false;
                    }
                    else
                    {
                        adjacencyList.get(v1).add(v2);
                        return true;
                    }
                }
                else
                {
                    adjacencyList.put(v2, new HashSet<>());
                    if(adjacencyList.get(v1).contains(v2))
                    {
                        return false;
                    }
                    else
                    {
                        adjacencyList.get(v1).add(v2);
                        return true;
                    }

                }
            }
            else
            {
                adjacencyList.put(v1, new HashSet<>());

                if(adjacencyList.containsKey(v2))
                {
                    if(adjacencyList.get(v1).contains(v2))
                    {
                        return false;
                    }
                }
                else
                {
                    adjacencyList.get(v1).add(v2);
                    return true;
                }
            }
            return true; 
        }

        /*
         * Método que devuelve el conjunto de vértices adyacentes al vértice dado v en el grafo.
         */
        public Set<V> obtainAdjacents(V v) throws Exception{

            return adjacencyList.get(v);
 
        }
        
        /*
         * Método que verifica si contiene el vertice dado.
         */
        public boolean containsVertex(V v){
            if(adjacencyList.containsKey(v))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        @Override

        /*
         * Método que devuelve la lista de adyacencia.
         */
        public String toString(){
            return "La lista es: " + adjacencyList;
            
            
        }

        /*
         * Método que calcula el camino más corto entre dos vertices.
         */
        public List<V> shortestPath(V v1, V v2){
            
            /*
             * Primero verificaremos si los vertices existen en el grafo
             */
            if (!adjacencyList.containsKey(v1) || !adjacencyList.containsKey(v2)) {
                return null; 
            }

            /*
             * Mapa que almacena el costo mínimo para llegar a cada vértice desde el vértice inicial.
             */
            Map<V, Integer> costoMinimo = new HashMap<>();

            /*
             * Mapa que almacena el predecesor de cada vértice en el camino mínimo.
             */
            Map<V, V> predecesor = new HashMap<>();

            /*
             *  Cola de prioridad que ordena los vértices en base a su costo mínimo.
             */
            PriorityQueue<V> cola = new PriorityQueue<>(Comparator.comparingInt(costoMinimo::get));
            
            /*
             * Inicializamos los mapas costoMinimo y predecesor con valores iniciales. 
             * Establecemos el costo mínimo de llegar al vértice inicial (v1) como 0 y lo agrega a la cola de prioridad.
             */
            for (V vertice : adjacencyList.keySet()) {
                costoMinimo.put(vertice, Integer.MAX_VALUE);
                predecesor.put(vertice, null);
            }
                costoMinimo.put(v1, 0);
                cola.add(v1);

            /*
             * Mientras la cola de prioridad no esté vacía, extraemos el vértice con el costo mínimo actual. 
             * Luego, para cada vecino del vértice actual, calculamos el nuevo costo para llegar a ese vecino y actualizamos los mapas costoMinimo 
             * y predecesor si el nuevo costo es menor que el costo actualmente registrado para ese vecino.
             */
            while (!cola.isEmpty()) {
                V verticeActual = cola.poll();
        
                if (verticeActual.equals(v2)) {
                    break; 
                }
            
                for (V vecino : adjacencyList.get(verticeActual)) {

                    int nuevoCoste = costoMinimo.get(verticeActual) + 1; 
                    if (nuevoCoste < costoMinimo.get(vecino)) {
                        costoMinimo.put(vecino, nuevoCoste);
                        costoMinimo.put(vecino, verticeActual);
                        cola.add(vecino);
                    }
                }
            }

            /*
             * Después de encontrar el camino más corto, reconstruimos el camino desde el vértice final (v2) hasta el vértice inicial (v1) utilizando el mapa predecesor.
             */
                List<V> camino = new ArrayList<>();
                V actual = v2;
                while (actual != null) {
                    camino.add(actual);
                    actual = predecesor.get(actual);
                }
                Collections.reverse(camino);

                /*
                / Verificamos si el camino encontrado realmente comienza desde el vértice v1.
                */
                if (camino.get(0) != v1) {
                    return null;
                }
                
                return camino;
        }
    }
    
}
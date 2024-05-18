# PRACTICA 5

# Autor
Raúl Quintano Vázquez

# Descripción
Este codigo calcula cual es el camino más corto entre dos nodos en un grafo.

# Licencia
Copyright [2024] [Raul Quintano Vazquez]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


## Estado del proyecto

Finalizado. Listo para su uso.

## Instalación

Clona el repositorio de este proyecto de GitHub y péguelo en el directorio que desee
https://github.com/raulquintano/practica5.git


## Funcionamiento

En primer lugar, se asigna un costo de 0 al nodo inicial y se asigna un costo de infinito a todos los demás nodos. Este costo representa la distancia más corta conocida desde el nodo inicial hasta cada nodo. Despues, se crea una cola de prioridad que contiene todos los nodos del grafo, ordenados por su costo actual.

Mientras la cola de prioridad no esté vacía, se extrae el nodo con el costo más bajo. Si el nodo actual es el nodo destino, el algoritmo termina, ya que se ha encontrado el camino más corto al nodo destino.

Para cada vecino del nodo actual, se calcula una nueva distancia desde el nodo inicial pasando por el nodo actual. Si esta nueva distancia es menor que la distancia actualmente registrada para ese vecino, se actualiza el costo del vecino y se establece el nodo actual como su predecesor. El vecino se actualiza en la cola de prioridad con su nuevo costo.

El proceso se repite extrayendo el siguiente nodo con el costo más bajo de la cola de prioridad y actualizando los costos de sus vecinos.
Este proceso continúa hasta que la cola de prioridad esté vacía o se haya encontrado el camino más corto al nodo destino.

Una vez que se encuentra el camino más corto al nodo destino, se puede reconstruir el camino desde el nodo destino al nodo inicial utilizando los predecesores almacenados durante el proceso de actualización de costos.
Se inicia en el nodo destino y se sigue hacia atrás a través de los predecesores hasta llegar al nodo inicial. Finalmente, se invierte la lista para obtener el camino en el orden correcto.

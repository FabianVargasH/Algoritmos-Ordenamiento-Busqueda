# Estrategia de aprendizaje - Algoritmos de ordenamiento y búsqueda <img width="81" height="90" alt="Logo Cenfotec Actual (1)" src="https://github.com/user-attachments/assets/6e30b4e1-00af-48cc-871e-b48cdbc2275d" /> 

## Descripción General

Programa en Java que permite al usuario trabajar con un arreglo estático de palabras (`String[]`), aplicar distintos algoritmos de ordenamiento y realizar búsqueda binaria sobre el arreglo ya ordenado.

---

## ¿Qué hace el programa?

1. **Ingreso de datos** — El usuario define el tamaño del arreglo e ingresa las palabras una por una.
2. **Menú de ordenamiento** — Se presentan 5 algoritmos para ordenar el arreglo alfabéticamente.
3. **Búsqueda binaria** — Una vez ordenado el arreglo, el usuario puede buscar cualquier palabra.

---

## Algoritmos de Ordenamiento Implementados

Cada algoritmo está programado como una subrutina independiente, con sus pasos comentados y su complejidad temporal indicada.

| Algoritmo | Complejidad Temporal | Descripción breve |
|-----------|---------------------|-------------------|
| **Selección** *(Selection Sort)* | O(n²) | Busca el mínimo en cada pasada y lo coloca en su posición correcta. |
| **Inserción** *(Insertion Sort)* | O(n²) | Toma cada elemento e inserta en la posición correcta dentro de la parte ya ordenada. |
| **Burbuja** *(Bubble Sort)* | O(n²) | Compara pares adyacentes y los intercambia repetidamente hasta ordenar todo. |
| **Mezcla** *(Merge Sort)* | O(n log n) | Divide el arreglo a la mitad recursivamente y luego fusiona las mitades ordenadas. |
| **Rápido** *(Quick Sort)* | O(n log n) promedio | Elige un pivote, coloca los menores a su izquierda y los mayores a su derecha, luego ordena cada parte recursivamente. |

---

## Búsqueda Binaria

- **Complejidad:** O(log n)
- **Requisito:** El arreglo debe estar ordenado previamente.
- **Funcionamiento:** Divide el arreglo por la mitad en cada paso, comparando el elemento central con la palabra buscada. Si es mayor, busca en la mitad izquierda; si es menor, en la derecha. Repite hasta encontrar la palabra o confirmar que no existe.

---

## Estructura del Proyecto

```
Algoritmos-Ordenamiento-Busqueda/
├── Main.java               
```

---

## Autor
Fabián Vargas Hidalgo


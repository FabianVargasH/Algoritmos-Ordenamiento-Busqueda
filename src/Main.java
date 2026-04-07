import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Ingrese el tamaño del arreglo de palabras: ");
            int tamaño = Integer.parseInt(br.readLine());
            String[] palabras = new String[tamaño];
            System.out.println("\nIngrese " + tamaño + " palabras:");
            for (int i = 0; i < tamaño; i++) {
                System.out.print("Palabra " + (i + 1) + ": ");
                palabras[i] = br.readLine();
            }
            mostrarMenu(palabras, br);
        } catch (IOException e) {
            System.out.println("Error al leer entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número válido.");
        }
    }
    public static void mostrarMenu(String[] palabras, BufferedReader br) {
        try {
            int opcion = 0;
            while (true) {
                System.out.println("\n========== MENÚ DE ORDENAMIENTO ==========");
                System.out.println("1. Selection Sort (O(n²))");
                System.out.println("2. Insertion Sort (O(n²))");
                System.out.println("3. Bubble Sort (O(n²))");
                System.out.println("4. Merge Sort (O(n log n))");
                System.out.println("5. Quick Sort (O(n log n) promedio, O(n²) peor caso)");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                try {
                    opcion = Integer.parseInt(br.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Opción inválida. Intente de nuevo.");
                    continue;
                }
                if (opcion == 6) {
                    System.out.println("Gracias por usar el programa.");
                    break;
                }
                if (opcion >= 1 && opcion <= 5) {
                    // copia del arreglo para ordenamiento
                    String[] copia = Arrays.copyOf(palabras, palabras.length);
                    switch (opcion) {
                        case 1:
                            selectionSort(copia);
                            System.out.println("\nArreglo ordenado con Selection Sort");
                            break;
                        case 2:
                            insertionSort(copia);
                            System.out.println("\nArreglo ordenado con Insertion Sort");
                            break;
                        case 3:
                            bubbleSort(copia);
                            System.out.println("\nArreglo ordenado con Bubble Sort");
                            break;
                        case 4:
                            mergeSort(copia, 0, copia.length - 1);
                            System.out.println("\nArreglo ordenado con Merge Sort");
                            break;
                        case 5:
                            quickSort(copia, 0, copia.length - 1);
                            System.out.println("\nArreglo ordenado con Quick Sort");
                            break;
                    }
                    System.out.println("Arreglo ordenado: " + Arrays.toString(copia));
                    System.out.print("\n¿Desea realizar una búsqueda binaria? (s/n): ");
                    String respuesta = br.readLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        System.out.print("Ingrese la palabra a buscar: ");
                        String buscar = br.readLine();
                        int posicion = busquedaBinaria(copia, buscar);
                        if (posicion != -1) {
                            System.out.println("La palabra '" + buscar + "' se encontró en la posición: " + posicion);
                        } else {
                            System.out.println("La palabra '" + buscar + "' NO se encontró en el arreglo.");
                        }
                    }
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer entrada: " + e.getMessage());
        }
    }
    //Selection Sort
    //Complejidad de tiempo: O(n^2)
    //Busca el elemento minimo de la seccion no ordenada y lo coloca al inicio
    public static void selectionSort(String[] palabras){
        int n = palabras.length;
        int minimo;
        String temp;
        // Se recorre todo el arreglo excepto el ultimo elemento
        for (int i = 0; i<n-1;i++){
            // Se asume que el elemento actual es el minimo
            minimo = i;
            // Buscar el elemento minimo en el resto del arreglo
            for (int j = i + 1; j<n;j++){
                // Comparar strings alfabeticamente
                if(palabras[j].compareTo(palabras[minimo])<0){
                    minimo = j;
                }
            }
            // Intercambiar el elemento actual con el minimo encontrado
            temp = palabras[i];
            palabras[i] = palabras[minimo];
            palabras[minimo] = temp;
        }
    }

    //Insertion Sort
    // Complejidad de tiempo: O(n^2)
    //Construye el arreglo ordenado uno a uno, insertando cada elemento en su posicion correcta
    public static void insertionSort(String[] palabras){
        int n = palabras.length;
        String[] nuevo = new String[n];
        int posicion = 0;
        int insertados = 0;
        for(int i = 0; i < n; i++){
            if(i == 0){
                // El primer elemento se coloca directamente
                nuevo[i] = palabras[i];
                insertados = 1;
            } else {
                // Buscar la posición correcta para insertar el elemento
                posicion = insertados; // Posición por defecto al final
                for(int j = 0; j < insertados; j++){
                    // Si encuentra una palabra mayor, inserta antes
                    if(palabras[i].compareTo(nuevo[j]) <= 0){
                        posicion = j;
                        break;
                    }
                }
                // Desplazar elementos hacia la derecha desde el final
                for(int k = insertados; k > posicion; k--){
                    nuevo[k] = nuevo[k - 1];
                }
                // Insertar el elemento en su posición correcta
                nuevo[posicion] = palabras[i];
                insertados++;
            }
        }
        // Copiar el arreglo ordenado de vuelta al arreglo original
        for(int c = 0; c < n; c++){
            palabras[c] = nuevo[c];
        }
    }

    //Bubble Sort
    // Complejidad de tiempo: O(n^2) en el peor caso, O(n) en el mejor caso
    // Compara elementos adyacentes y los intercambia si estan en orden incorrecto,
    //repitiendo el proceso hasta que no haa mas intercambios
    public static void bubbleSort(String[] palabras){
        int n = palabras.length;
        String temp;
        boolean desordenado;

        for(int i = 0; i<n;i++){
            desordenado = false;
            // Se comparan elementos adyacentes
            for(int j = 0; j<n-1-i;j++){
                // Si el elemento actual es mayot que el siguiente, intercambiar
                if(palabras[j].compareTo(palabras[j+1]) > 0){
                    temp = palabras[j];
                    palabras[j] = palabras[j+1];
                    palabras[j+1] = temp;
                    desordenado = true;
                }
            }
            // Si no hubo intercambios, el arreglo esta ordenado
            if(!desordenado) break;
        }
    }

    //Merge Sort
    // Complejidad de tiempo: O(n log n) en todos los casos
    // Divide el arreglo en mitades recursivamente, las ordena y luego las mezcla
    public static void mergeSort(String[] palabras, int inicio, int fin) {
        if (inicio < fin) {
            // Encontrar el punto medio
            int mid = (inicio + fin) / 2;
            // Dividir y ordenar izquierda
            mergeSort(palabras, inicio, mid);
            // Dividir y ordenar derecha
            mergeSort(palabras, mid + 1, fin);
            // Mezclar directamente sin metodo separado
            String[] temp = new String[fin - inicio + 1];
            int i = inicio, j = mid + 1, k = 0;
            // Comparar elementos de ambos subarreglos y copiar el menor
            while (i <= mid && j <= fin) {
                if (palabras[i].compareTo(palabras[j]) <= 0) {
                    temp[k++] = palabras[i++];
                } else {
                    temp[k++] = palabras[j++];
                }
            }
            // Copiar elementos restantes del subarreglo izquierdo (si existen)
            while (i <= mid) temp[k++] = palabras[i++];
            // Copiar elementos restantes del subarreglo derecho (si existen)
            while (j <= fin) temp[k++] = palabras[j++];
            // Copiar elementos del arreglo temporal de vuelta al arreglo original
            for (int x = 0; x < temp.length; x++) {
                palabras[inicio + x] = temp[x];
            }
        }
    }

    // Quick Sort
    // Complejidad de tiempo: O(n log n) promedio, O(n^2) en el peor caso
    // Descripción: Divide el arreglo usando un pivote, ordena recursivamente las particiones
    // y luego las combina. El pivote es un elemento que separa los menores a la izquierda
    // y los mayores a la derecha.
    public static void quickSort(String[] palabras, int inicio, int fin) {
        // si hay más de un elemento
        if (inicio < fin) {
            // Elegir el último elemento como pivote
            String pivote = palabras[fin];
            // i marca el final de la sección de elementos menores o iguales
            int i = inicio - 1;
            // Recorrer desde inicio hasta fin-1 para particionar el arreglo
            for (int j = inicio; j < fin; j++) {
                // Si el elemento actual es menor o igual al pivote
                if (palabras[j].compareTo(pivote) <= 0) {
                    i++;
                    // Intercambiar el elemento menor con la posición i
                    String temp = palabras[i];
                    palabras[i] = palabras[j];
                    palabras[j] = temp;
                }
            }
            // Colocar el pivote en su posición final correcta
            String temp = palabras[i + 1];
            palabras[i + 1] = palabras[fin];
            palabras[fin] = temp;
            // Posición final del pivote
            int pivoteFinal = i + 1;
            // Ordenar recursivamente la parte izquierda del pivote
            quickSort(palabras, inicio, pivoteFinal - 1);
            // Ordenar recursivamente la parte derecha del pivote
            quickSort(palabras, pivoteFinal + 1, fin);
        }
    }
    // Binary Search
    // Complejidad de tiempo: O(log n), En cada iteración, el espacio de búsqueda se reduce
    // a la mitad. Para un arreglo de n elementos, se necesitan como máximo log_2(n)
    // iteraciones para encontrar el elemento o determinar que no existe.
    // Ejemplo: Para 1000 elementos se necesitan máximo 10 iteraciones (log_2 1000 = 10)
    // Precondición: El arreglo DEBE estar ordenado
    // Descripción: Divide el espacio de búsqueda por la mitad en cada iteración,
    // comparando el elemento buscado con el elemento del medio usando compareTo().
    // Si coinciden, se encontró. Si es menor, busca en la mitad izquierda;
    // si es mayor, en la derecha.
    public static int busquedaBinaria(String[] palabras, String palabraBuscar) {
        // Índice del lado izquierdo del rango de búsqueda
        int izquierdo = 0;
        // Índice del lado derecho del rango de búsqueda
        int derecho = palabras.length - 1;
        // Índice del elemento del medio
        int pivote = (izquierdo + derecho) / 2;
        // Continuar mientras la palabra del medio no sea igual a la palabra buscada
        while (palabras[pivote].compareTo(palabraBuscar) != 0) {
            // Si la palabra del medio es menor que la buscada, buscar en la derecha
            if (palabras[pivote].compareTo(palabraBuscar) < 0) {
                izquierdo = pivote + 1;
            }
            // Si la palabra del medio es mayor que la buscada, buscar en la izquierda
            else {
                derecho = pivote - 1;
            }
            // Si los índices se cruzaron, la palabra no existe en el arreglo
            if (izquierdo > derecho) {
                return -1;
            }
            // Recalcular el pivote con el nuevo rango
            pivote = (izquierdo + derecho) / 2;
        }
        // Si se encontró, retornar la posición
        return pivote;
    }
}
package arboleda;

import java.util.Scanner;

public class ArbolBinario {

    public Nodo[] listadoDeNodos;
    private final int capacidad;
    Scanner teclado = new Scanner(System.in);

    public ArbolBinario(int grado, int nivel) {
        this.capacidad = (int) Math.pow(grado, nivel) - 1;
        this.listadoDeNodos = new Nodo[this.capacidad];
//        System.out.println("Inicializando arbol");
        for (int i = 0; i < listadoDeNodos.length; i++) {
            listadoDeNodos[i] = null;
//            System.out.println(listadoDeNodos[i]);
        }
    }

    public boolean insert(Nodo dato, int posicion) {

        if (listadoDeNodos[posicion] == null && posicion < capacidad) {
            listadoDeNodos[posicion] = dato;
//            System.out.println("elemento insertado");
//            for (int i = 0; i < capacidad; i++) {
//                System.out.println(listadoDeNodos[i]);
//            }
            return true;

        } else {
            System.err.println("No se pudo insertar en el arbol");
            return false;
        }
    }

    private int calcularAnterior(int i) {
        if (i % 2 == 0) {
            i = (i - 2) / 2;
        } else {
            i = (i - 1) / 2;
        }
        return i;
    }

    public int obtenerIndice(Nodo[] arbol, Nodo buscado) {
        for (int i = 0; i < arbol.length; i++) {
            if (arbol[i] == buscado) { // compara referencias
                return i;
            }
        }
        return -1; // si no se encuentra
    }

    public int decision(int opcion, Nodo nodo) {

        int i = obtenerIndice(listadoDeNodos, nodo);

        switch (opcion) {
           case 1 -> {
                if (nodo.getOpcion1().contains("volver") || nodo.getOpcion1().contains("Volver")) {
                    i = 0;
                    return i;
                } else {
                    i = (i * 2) + 1;
                    return i;
                }
            }
            case 2 -> {
                if (nodo.getOpcion2().contains("volver") || nodo.getOpcion2().contains("Volver") ) {
                    i = 0;
                    return i;
                } else if (nodo.getOpcion2().contains("gracias")) {
                    i = 16;
                    return i;
                } else {
                    i = (i * 2) + 2;
                    return i;
                }
            }
            default ->
                System.out.println("no ingresó una opcion valida");
        }
        return i;
    }

    public void jugar(int i) {
        System.out.println(listadoDeNodos[i].getEvento());
        System.out.println(listadoDeNodos[i].getOpcion1());
        System.out.println(listadoDeNodos[i].getOpcion2());

        if (listadoDeNodos[i].isContinuasVivo()) {
            int opcion = teclado.nextInt();
            i = decision(opcion, listadoDeNodos[i]);
            jugar(i);
        } else {

        }
    }

}

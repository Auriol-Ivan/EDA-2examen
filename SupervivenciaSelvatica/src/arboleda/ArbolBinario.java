package arboleda;

import java.util.Scanner;

public class ArbolBinario {

    public Nodo[] listadoDeNodos;
    private final int capacidad;
    private String nombreArbol;

    public String getNombreArbol() {
        return nombreArbol;
    }
    Scanner tecladoNum = new Scanner(System.in);
    Scanner tecladoStr = new Scanner(System.in);
    public ArbolBinario[] listaDeArboles = new ArbolBinario[10];

    public ArbolBinario(String nombreArbol) {
        capacidad = (int) Math.pow(2, 5) - 1;
        this.nombreArbol = nombreArbol;
        this.listadoDeNodos = new Nodo[this.capacidad];
        for (int i = 0; i < listadoDeNodos.length; i++) {
            listadoDeNodos[i] = null;
        }
    }

    public boolean insert(Nodo dato, int posicion) {

        if (listadoDeNodos[posicion] == null && posicion < capacidad) {
            listadoDeNodos[posicion] = dato;
//            System.out.println("elemento insertado"); //controlador para ver si se insertaban
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
        int indice;
        if (i % 2 == 0) {
            indice = (i - 2) / 2;
        } else {
            indice = (i - 1) / 2;
        }
        return indice;
    }

    public int obtenerIndice(Nodo[] arbol, Nodo buscado) {
        for (int i = 0; i < arbol.length; i++) {
            if (arbol[i] == buscado) {
                return i;
            }
        }
        return -1;
    }

    public int decision(int opcion, Nodo nodo) {

        int i = obtenerIndice(listadoDeNodos, nodo);

        switch (opcion) {
            case 1 -> {
                if (nodo.getOpcion1().contains("volver")) {
                    i = 0;
                    return i;
                } else {
                    i = (i * 2) + 1;
                    return i;
                }
            }
            case 2 -> {
                if (nodo.getOpcion2().contains("volver")) {
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
            case 3 -> {
                System.out.println("Muchas gracias por jugar!");
                System.exit(0);
                break;
            }

            default ->
                System.out.println("no ingresó una opcion valida");
        }
        return i;
    }

    public void jugar(int i) {
        System.out.println(listadoDeNodos[i].getEvento());
        System.out.println("1- "+listadoDeNodos[i].getOpcion1());
        System.out.println("2- "+listadoDeNodos[i].getOpcion2());
        System.out.println("3- Salir del juego.");
        if (listadoDeNodos[i].isContinuasVivo()) {
            int opcion = tecladoNum.nextInt();
            i = decision(opcion, listadoDeNodos[i]);
            jugar(i);
        } else {

        }
    }

    //metodo para crear arbol desde menú
    public ArbolBinario crearArbol() {
        boolean cambio;
        int contador = 0;
        Nodo nuevo;
        int padre;
        String otro;
        String nombreArbolNuevo;
        System.out.println("Ingrese el nombre de la historia.");
        nombreArbolNuevo = tecladoStr.nextLine();
        ArbolBinario arbolCreado = new ArbolBinario(nombreArbolNuevo);

        System.out.println("Para crear cada Nodo se necesita: "
                + "\nUn Evento: que cuenta el punto donde se lleva a la toma de decisión, "
                + "\nOpción1, Opción2 que representan las posibles decisiones a tomar, "
                + "\nUn estado que reperesenta si en este punto se fracasa o no (si/no)");

        do {
            if (contador == 0) {
                nuevo = crearNodo();
                arbolCreado.insert(nuevo, contador);
                contador++;
            } else {
                cambio = false;

                do {
                    if (contador > capacidad) {
                        break;
                    }

                    padre = calcularAnterior(contador);

                    if (arbolCreado.listadoDeNodos[padre] != null) {
                        if (contador % 2 == 1) {
                            if (!arbolCreado.listadoDeNodos[padre].getOpcion1().isBlank()) {
                                System.out.println("contador " + contador + " padre" + padre);
                                System.out.println("Esto es consecuencia de elegir " + arbolCreado.listadoDeNodos[padre].getOpcion1());
                                nuevo = crearNodo();
                                arbolCreado.insert(nuevo, contador);
                                cambio = true;
                            }
                        } else {
                            if (!arbolCreado.listadoDeNodos[padre].getOpcion2().isBlank()) {
                                System.out.println("contador " + contador + " padre" + padre);
                                System.out.println("Esto es consecuencia de elegir " + arbolCreado.listadoDeNodos[padre].getOpcion2());
                                nuevo = crearNodo();
                                arbolCreado.insert(nuevo, contador);
                                cambio = true;
                            }
                        }
                    }

                    if (!cambio) {
                        contador++;
                    }

                } while (!cambio && contador < capacidad);

                if (cambio) {
                    System.out.println("elemento insertado");
                    for (int i = 0; i < capacidad; i++) {
                        System.out.println(arbolCreado.listadoDeNodos[i]);
                    }
                    contador++;  // avanzar al siguiente intento
                }
            }

            if (contador >= capacidad) {
                System.out.println("arbol lleno, no se pueden agregar más nodos.");
                break;
            }

            System.out.println("Desea agregar otro nodo?");
            System.out.println("1- Si");
            System.out.println("2- No");
            otro = tecladoStr.nextLine();

        } while (!otro.equalsIgnoreCase("no") && !otro.equals("2") && contador < capacidad);
        return arbolCreado;
    }

    private Nodo crearNodo() {
        String evento;
        String opcion1;
        String opcion2;
        String estadoString;
        boolean estado = true;
        System.out.println("Ingrese el Evento:");
        evento = tecladoStr.nextLine();
        System.out.println("Ingrese la Opcion1:");
        opcion1 = tecladoStr.nextLine();
        System.out.println("Ingrese la Opcion2:");
        opcion2 = tecladoStr.nextLine();
        System.out.println("En este punto el personaje fracasó?");
        estadoString = tecladoStr.nextLine();
        if (estadoString.contains("si")) {
            estado = false;
        }
        Nodo nuevo = new Nodo(evento, opcion1, opcion2, estado);

        return nuevo;
    }

    public void insertarEnListaDeArboles(ArbolBinario arbol) {
        boolean insertado = false;

        for (int i = 0; i < listaDeArboles.length; i++) {
            if (listaDeArboles[i] == null) {
                listaDeArboles[i] = arbol;
                System.out.println("Árbol insertado en la posición " + i);
                insertado = true;
                break;
            }
        }
        if (!insertado) {
            System.out.println("No hay espacio para nuevas aventuras.");
        }
    }

    public void menuPrincipal() {
        int opcion;
        do {
            System.out.println("Bienvenido a nuestro juego! Que decea hacer?\n1- Crear historia\n2- Jugar\n3- Salir");
            opcion = tecladoNum.nextInt();
            switch (opcion) {
                case 1:
                    ArbolBinario nuevoArbol = crearArbol();
                    insertarEnListaDeArboles(nuevoArbol);
                    break;
                case 2:
                    seleccionarYJugar();
                    break;
                case 3:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("no ingresó una opcion valida");
            }
        } while (opcion != 3);

    }

    public void seleccionarYJugar() {
        System.out.println("Seleccione la historia que desea jugar:");
        for (int i = 0; i < listaDeArboles.length; i++) {
            if (listaDeArboles[i] != null) {
                System.out.println(i + " - " + listaDeArboles[i].getNombreArbol());
            }
        }
        int seleccion = tecladoNum.nextInt();

        if (seleccion >= 0 && seleccion < listaDeArboles.length && listaDeArboles[seleccion] != null) {
            listaDeArboles[seleccion].jugar(0);
        } else {
            System.out.println("Selección inválida. Intente nuevamente.");
        }
    }

}

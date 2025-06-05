package arboleda;

public class ArbolEDA {

    public static void main(String[] args) {
        Nodo nodo0 = new Nodo("Esta historia trata de un aventurero que debe entregar medicina a una doctora en la selva. \n"
                + "Inicia su camino saltando de un avion sobre un rio a una posicion de 25 km al sud oeste de la ultima posicionde la doctora conocida.\n"
                + "dos opciones para iniciar su camino", "1- Inicia camino por el rio ", "2- Iniciar camino por la selva", true);
        Nodo nodo1 = new Nodo("safa de los cocodrilos y continua su camino pero estas mas lejos de la doctora", "1 continuar ", "2 volver al inicio", true);//rio
        Nodo nodo3 = new Nodo("continuas tu camino por el rio pero estas mas lejos de la doctora, debes elegir entre ", "1 continuar ", "2 volver al inicio", true);//rio
        Nodo nodo7 = new Nodo("Caminar tanto por el rio es muy agotador, y en el minimo descuido fuiste atacado\n por un cocodrilo. Has fracasado, desea volver a jugar? ", "1 - si, volver a jugar", "2 - no, muchas gracias", true);//rio
        Nodo nodo16 = new Nodo("Muchas gracias por haber jugado! te esperamos la próxima. (apruebenos profe) ", "", "", false);//rio
        Nodo nodo2 = new Nodo("Ingresa por la selva atravezando la maelaza con machete \n"
                + "	A los 5 km se encuenta el acantilado y por dreatras Aparece jaguar tiene dos opciones para cruzarlo \n"
                + "	Tiene la opcion de curzar por el tronco o Con la liana al estilo tarzan", "1 Cruza por tronco ", "2 Cruza con liana ", true);//selva
        Nodo nodo5 = new Nodo("el jaguar lo alcanzó, GAME DELICIOUS (firma: el Jaguar), desea volver a jugar? ", "1 - si, volver a jugar", "2 - no, muchas gracias", true);//tronco
        Nodo nodo6 = new Nodo("Encontro uno de los campamentos de la doctora, pero su ultima cominicacion fue a 15 km al norte, \n"
                + "	para enontrar el camino hacia la doctora tiene 2 opciones; subir al arbol para tener mejor panorama del lugar o \n"
                + "	ir a donde los monos aullan (Estos son molestados cuando hay aolgo o alguien cerca. Sera la doctora? )", "1 Continua por el camino de los monos aulladores.", "2 subir al arbol.", true);//liana
        Nodo nodo13 = new Nodo("Se siente cada vez perdido, hasta el fin de sus dias (felicitaciones, mataste a la doctora). Has fracasado! desea volver a jugar? ", "1 - si, volver a jugar", "2 - no, muchas gracias", true);//mono
        Nodo nodo14 = new Nodo("ya en lo alto del arbol, a lo lejos se ve humo saliendo de entre las copas de los arboles y decides ir en esa direccion \n"
                + "	En el camino escuchas gritos de auxilio, mientras te acercas encuentras un bunquer antiguo pero en la entrada se encuentra una serpiente", "1 Cruzar rapido", "2 cruzar despacio", true);//arbol
        Nodo nodo29 = new Nodo("La serpiente alcanza a despertarse pero no a picarte.\n"
                + "	Al entrar en el bunquer, encuentras a los pocos metros a la doctora, gravemente enferma pero con las medicinas consigues salvarla. \nHas sobrevivido! Felicitaciones!! te esperamos en el proximo juego! , desea volver a jugar? ", "1 - si, volver a jugar", "2 - no, muchas gracias", true);//rapido
        Nodo nodo30 = new Nodo("la serpiente se despierta y te pica. Has fracasado! desea volver a jugar? ", "1 - si, volver a jugar", "2 - no, muchas gracias", true);//lento

        ArbolBinario arbol = new ArbolBinario(2, 5);

        arbol.insert(nodo0, 0);//nodo raiz
        arbol.insert(nodo1, 1);//opcion 1
        arbol.insert(nodo2, 2);//opcion2
        arbol.insert(nodo3, 3);//opcion2
        arbol.insert(nodo5, 5);
        arbol.insert(nodo6, 6);
        arbol.insert(nodo7, 7);
        arbol.insert(nodo13, 13);
        arbol.insert(nodo14, 14);
        arbol.insert(nodo16, 16);
        arbol.insert(nodo29, 29);
        arbol.insert(nodo30, 30);

        arbol.jugar(0);
    }

}

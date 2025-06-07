package arboleda;

public class ArbolEDA {

    public static void main(String[] args) {
        Nodo nodo0 = new Nodo("Esta historia sigue los pasos de un valiente aventurero que debe entregar medicina vital a una doctora perdida en lo profundo de la selva.\n"
                + "Todo comienza con un salto desde un avión sobre un río caudaloso, cayendo a unos 25 km al sudoeste del último punto conocido donde estuvo la doctora.\n" 
                + "Desde aquí, el aventurero debe elegir cómo continuar:\n"
                , "1 - Iniciar por el curso del río. ", "2 - Iniciar camino por la selva", true);
        Nodo nodo1 = new Nodo("Te adentras por el río. Las aguas son agitadas, y no pasa mucho tiempo hasta que cocodrilos empiezan a acecharte.\n" + "Con agilidad y suerte, lográs escapar… pero te alejaste aún más de donde podría estar la doctora.\n" + "Estas seguro de... Contiruar por el rio o pensaste mejor en volver?\n", "1 - Continuar por el río. ", "2 - Volver al punto de inicio.", true);//rio
        Nodo nodo3 = new Nodo("Continuás por el río, aunque cada vez se hace más difícil avanzar. El paisaje se vuelve hostil, y la corriente te aleja de tu objetivo. Pero seguís.\n"+"Aún puedes elegir en: \n", "1 - Seguir adelante. ", "2 - Volver al inicio", true);//rio
        Nodo nodo7 = new Nodo("Bien! Tu nunca te rindes. Pero caminar tanto por el río te agota.\n"+ "En un momento de distracción, un cocodrilo salta desde el agua y te ataca\n"+ "No lo viste venir. Has fracasado\n"+" ¿Querés volver a intentarlo? \n", "1 - Si, volver a jugar", "2 - No, muchas gracias", true);//rio
        Nodo nodo16 = new Nodo("Muchas gracias por haber jugado! Te esperamos la próxima. (Apruebenos profe)\n ", "", "", false);//rio
        Nodo nodo2 = new Nodo("Te abrís paso con el machete entre la densa vegetación. A los 5 km, llegás a un acantilado. \n"
                + "Justo entonces, escuchás un rugido... un jaguar aparece entre los árboles. ¡No hay tiempo que perder! \n"
                + "Tenés dos opciones para cruzar el abismo:\n","1 - Cruzar por un tronco. ", "2 - Usar una liana, como Tarzán. ", true);//selva
        Nodo nodo5 = new Nodo("Intentás cruzar por el tronco, pero el jaguar es más rápido. Te alcanza justo antes de llegar al otro lado.\n" + "GAME OVER. El jaguar te firma: 'Delicioso'." + "¿Querés volver a jugar? \n" , "1 - "
                + "Si, volver a jugar", "2 - No, muchas gracias!", true);//tronco
        Nodo nodo6 = new Nodo("Con valentía, tomás impulso y cruzás con la liana. Al otro lado, descubrís uno de los campamentos de la doctora.\n"
                + "Pero en su diario de campo, encontrás su última anotación: “Me dirijo 15 km al norte”.\n"
                + "Para orientarte, podés: \n", "1 - Seguir los sonidos de los monos aulladores (ellos siempre detectan movimientos extraños).\n", "2 - Subir a un árbol y buscar señales desde lo alto.", true);//liana
        Nodo nodo13 = new Nodo("Te guías por los aullidos, pero el camino es confuso. Pasan los días, y cada vez estás más perdido.\n" + "Tu búsqueda se vuelve un camino sin retorno...\n" + "Felicitaciones! has matado a la doctora." + "¿Querés volver a intentarlo?\n" , "1 - Si, volver a jugar", "2 - No, gracias", true);//mono
        Nodo nodo14 = new Nodo("Desde lo alto del árbol divisás una fina columna de humo en el horizonte.\n" +"¡Alguien podría estar allí! Caminás en esa dirección, y en el trayecto escuchás gritos de auxilio.\n" 
                + "Al acercarte, descubrís un viejo búnker cubierto por la maleza."
                + "Pero en la entrada… una serpiente duerme.\n" + "Ahora puedes: \n", "1 - Cruzar rápidamente.", "2 - Avanzar lentamente para no despertarla.", true);//arbol
        Nodo nodo29 = new Nodo("Corrés. La serpiente se mueve, pero no llega a morderte.\n"
                + "Entrás al búnker y, a pocos metros, encontrás a la doctora. Está muy enferma pero, con las medicinas que llevás, lográs salvarla.\n"+"¡Has cumplido tu misión! Has sobrevivido. ¡Felicitaciones!\n" +"Te esperamos en el proximo juego!\n" + "¿Querés volver a jugar?\n", "1 - Si, volver a jugar", "2 - No, muchas gracias!", true);//rapido
        Nodo nodo30 = new Nodo("Intentás avanzar lentamente… pero la serpiente se despierta y te pica antes de que puedas reaccionar.\n" + "Tu cuerpo se paraliza. Ya sabes cual es tu final y el de la doctora. Has fracasado\n"
                + "Quieres volver a intentarlo?", "1 - Si, volver a jugar", "2 - No, muchas gracias!", true);//lento

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

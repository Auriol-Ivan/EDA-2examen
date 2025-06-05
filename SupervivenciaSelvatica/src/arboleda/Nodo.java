package arboleda;

public class Nodo {
    private String evento;
    private String opcion1;
    private String opcion2;
    private boolean continuasVivo;

    public Nodo(String evento, String opcion1, String opcion2, boolean continuasVivo) {
        this.evento = evento;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.continuasVivo = continuasVivo;
    }

    public String getEvento() {
        return evento;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public boolean isContinuasVivo() {
        return continuasVivo;
    }



    @Override
    public String toString() {
        return "Nodo{" + "evento=" + evento + ", opcion1=" + opcion1 + ", opcion2=" + opcion2 + ", continuasVivo=" + continuasVivo + '}';
    }
    
    
    
}

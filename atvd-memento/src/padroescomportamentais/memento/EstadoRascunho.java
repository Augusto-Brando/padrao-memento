package padroescomportamentais.memento;

public class EstadoRascunho implements DocumentoEstado {
    private EstadoRascunho() {};
    private static EstadoRascunho instance = new EstadoRascunho();

    public static EstadoRascunho getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Rascunho";
    }
}
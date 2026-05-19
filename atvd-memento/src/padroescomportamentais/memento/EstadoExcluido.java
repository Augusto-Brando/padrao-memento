package padroescomportamentais.memento;

public class EstadoExcluido implements DocumentoEstado {
    private EstadoExcluido() {};
    private static EstadoExcluido instance = new EstadoExcluido();

    public static EstadoExcluido getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Excluido";
    }
}
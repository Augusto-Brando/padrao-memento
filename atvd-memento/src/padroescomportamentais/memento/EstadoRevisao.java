package padroescomportamentais.memento;

public class EstadoRevisao implements DocumentoEstado {
    private EstadoRevisao() {};
    private static EstadoRevisao instance = new EstadoRevisao();

    public static EstadoRevisao getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Revisao";
    }
}
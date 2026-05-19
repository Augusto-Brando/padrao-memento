package padroescomportamentais.memento;

public class EstadoArquivado implements DocumentoEstado {
    private EstadoArquivado() {};
    private static EstadoArquivado instance = new EstadoArquivado();

    public static EstadoArquivado getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Arquivado";
    }
}
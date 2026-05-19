package padroescomportamentais.memento;

public class EstadoPublicado implements DocumentoEstado {
    private EstadoPublicado() {};
    private static EstadoPublicado instance = new EstadoPublicado();

    public static EstadoPublicado getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Publicado";
    }
}
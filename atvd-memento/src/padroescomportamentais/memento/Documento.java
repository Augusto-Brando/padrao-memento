package padroescomportamentais.memento;

import java.util.ArrayList;
import java.util.List;

public class Documento {
    private DocumentoEstado estado;
    private List<DocumentoEstado> memento = new ArrayList<DocumentoEstado>();

    public DocumentoEstado getEstado() {
        return this.estado;
    }

    public void setEstado(DocumentoEstado estado) {
        this.estado = estado;
        this.memento.add(this.estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Indice invalido");
        }
        this.estado = this.memento.get(indice);
    }

    public List<DocumentoEstado> getEstados() {
        return this.memento;
    }
}
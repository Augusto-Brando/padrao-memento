package padroescomportamentais.memento;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteUnitarioMemento {

    @Test
    public void testSetEstado() {
        Documento doc = new Documento();
        doc.setEstado(EstadoRascunho.getInstance());
        assertEquals("Rascunho", doc.getEstado().getNomeEstado());
    }

    @Test
    public void testHistoricoEstados() {
        Documento doc = new Documento();
        doc.setEstado(EstadoRascunho.getInstance());
        doc.setEstado(EstadoRevisao.getInstance());
        doc.setEstado(EstadoPublicado.getInstance());
        assertEquals(3, doc.getEstados().size());
    }

    @Test
    public void testRestaurarEstadoAnterior() {
        Documento doc = new Documento();
        doc.setEstado(EstadoRascunho.getInstance());
        doc.setEstado(EstadoRevisao.getInstance());
        doc.setEstado(EstadoPublicado.getInstance());
        doc.restauraEstado(0);
        assertEquals("Rascunho", doc.getEstado().getNomeEstado());
    }

    @Test
    public void testRestaurarEstadoIntermediario() {
        Documento doc = new Documento();
        doc.setEstado(EstadoRascunho.getInstance());
        doc.setEstado(EstadoRevisao.getInstance());
        doc.setEstado(EstadoPublicado.getInstance());
        doc.restauraEstado(1);
        assertEquals("Revisao", doc.getEstado().getNomeEstado());
    }

    @Test
    public void testRestauraIndiceInvalidoNegativo() {
        Documento doc = new Documento();
        doc.setEstado(EstadoRascunho.getInstance());
        assertThrows(IllegalArgumentException.class, () -> {
            doc.restauraEstado(-1);
        });
    }

    @Test
    public void testRestauraIndiceInvalidoMaior() {
        Documento doc = new Documento();
        doc.setEstado(EstadoRascunho.getInstance());
        assertThrows(IllegalArgumentException.class, () -> {
            doc.restauraEstado(5);
        });
    }

    @Test
    public void testSingletonEstado() {
        EstadoRascunho instancia1 = EstadoRascunho.getInstance();
        EstadoRascunho instancia2 = EstadoRascunho.getInstance();
        assertSame(instancia1, instancia2);
    }

    @Test
    public void testFluxoCompletoDocumento() {
        Documento doc = new Documento();
        doc.setEstado(EstadoRascunho.getInstance());
        doc.setEstado(EstadoRevisao.getInstance());
        doc.setEstado(EstadoPublicado.getInstance());
        doc.setEstado(EstadoArquivado.getInstance());
        doc.setEstado(EstadoExcluido.getInstance());
        assertEquals(5, doc.getEstados().size());
        assertEquals("Excluido", doc.getEstado().getNomeEstado());
    }
}
package wax.wax.Dominio.modelo;
import java.util.LinkedHashSet;
import java.util.Set;


public class torreModel {
    private Integer id;

    private Integer torre;

    private Set<VisitanteModel> visitantes = new LinkedHashSet<>();

    private Set<correspondenciaModel> correspondencias = new LinkedHashSet<>();

    private Set<reservazonaModel> reservaZonas = new LinkedHashSet<>();

    private Set<usuarioresidenteModel> usuariosResidentes = new LinkedHashSet<>();
}

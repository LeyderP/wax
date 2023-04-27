package wax.wax.Dominio.modelo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class reservazonaModel {
    private Integer id;
    private usuarioresidenteModel identificacion;
    private torreModel torre;
    private zonacomunModel zonacomun;
    private LocalDate fecha;
    private Integer tiempoReserva;
}

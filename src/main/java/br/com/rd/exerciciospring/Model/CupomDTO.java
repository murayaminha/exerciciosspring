package br.com.rd.exerciciospring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class CupomDTO {

    private Long idCupom;
    private Long idCliente;
    private String dtVenda;
    private BigDecimal vlVenda;

}

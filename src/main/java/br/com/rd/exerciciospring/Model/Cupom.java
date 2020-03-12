package br.com.rd.exerciciospring.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_CUPOM")
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_CUPOM")
    private Long idCupom;

    @Column(name ="ID_CLIENTE")
    private Long idCliente;

    @Column(name="DT_VENDA")
    private String dtVenda;

    @Column(name="VL_VENDA")
    private BigDecimal vlVenda;




}

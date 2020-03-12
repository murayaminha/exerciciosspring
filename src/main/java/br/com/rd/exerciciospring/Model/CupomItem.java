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
@Table(name="TB_CUPOM_ITEM")
public class CupomItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_CUPOM_ITEM")
    private Long idCupomItem;

    @OneToOne
    @JoinColumn(name="IDCUPOM")
    private Cupom cupom;

    @OneToOne
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    @Column(name = "VL_PRODUTO")
    private BigDecimal vlProduto;







}

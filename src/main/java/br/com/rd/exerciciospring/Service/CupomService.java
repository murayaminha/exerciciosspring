package br.com.rd.exerciciospring.Service;

import br.com.rd.exerciciospring.Model.Cupom;
import br.com.rd.exerciciospring.Model.CupomDTO;
import br.com.rd.exerciciospring.Repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Service("CupomService")
public class CupomService {
    @Autowired
    CupomRepository repository;

    public ResponseEntity salvar (CupomDTO cupom){
        if (cupom == null || cupom.getIdCliente()==null){
            return ResponseEntity.badRequest().body(new Exception("idCliente não informado"));
        }
        if(cupom==null || cupom.getVlVenda()==null){
            return  ResponseEntity.badRequest().body(new Exception("Valor de venda inválido"));
        }
        Cupom cupom1 =new Cupom();
        cupom1.setDtVenda(cupom.getDtVenda());
        cupom1.setIdCliente(cupom.getIdCliente());
        cupom1.setVlVenda(cupom.getVlVenda());

        Cupom cupom2=repository.save(cupom1);
        CupomDTO cupomDTO =new CupomDTO();
        cupomDTO.setIdCupom(cupom2.getIdCupom());

        return ResponseEntity.ok().body(cupomDTO);
    }

    public ResponseEntity<List<Cupom>> fyndByIdClienteAndDtVenda(@PathParam("idClient") Long idClient,
                                                            @PathParam("dtVenda") String dtVenda){
        List<Cupom> cupom = new ArrayList<>();

        if (idClient != null && dtVenda != null){
            cupom = repository.fyndByIdClienteAndDtVenda(idClient,dtVenda);
        }
        if (cupom != null && cupom.size() > 0){
            return ResponseEntity.ok().body(cupom);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}

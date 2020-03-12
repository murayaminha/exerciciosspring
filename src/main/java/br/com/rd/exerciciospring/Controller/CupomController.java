package br.com.rd.exerciciospring.Controller;

import br.com.rd.exerciciospring.Service.CupomService;
import br.com.rd.exerciciospring.Model.CupomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
public class CupomController {

    @Autowired
    public CupomService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cupom")
    public ResponseEntity salvarCupom(@RequestBody CupomDTO cupom) {

        return service.salvar(cupom);
    }
    @GetMapping("/cupom")
    public ResponseEntity buscarCupom(@PathParam("idCliente")Long idClient, @PathParam("dtVenda")String dtVenda){

    return service.fyndByIdClienteAndDtVenda(idClient, dtVenda);
    }

}

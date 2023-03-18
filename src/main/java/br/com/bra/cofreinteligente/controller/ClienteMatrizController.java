package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.dto.ClienteMatrizDto;
import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.service.ClienteMatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ClienteMatriz")
public class ClienteMatrizController {

    @Autowired
    public ClienteMatrizService clienteMatrizService;

    @PostMapping
    public ResponseEntity<ClienteMatrizDto> addClienteMatriz(@RequestBody ClienteMatrizDto clienteMatrizDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteMatrizService.addClienteMatriz(clienteMatrizDto));
    }

    @GetMapping
    public ResponseEntity<Page<ClienteMatrizDto>> getClienteMatriz(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clienteMatrizService.getAllClienteMatriz(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteMatrizDto> getClienteMatrizById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clienteMatrizService.getClienteMatriz(id));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteClienteMatrizById(@PathVariable(value = "id") Long id) throws Exception {
//        clienteMatrizService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    @PatchMapping("/{id}")
    public ClienteMatrizDto alteraClienteMatrizNameById (@PathVariable(value = "id") Long id, @RequestBody ClienteMatrizDto clienteMatrizDto) throws Exception {
        return clienteMatrizService.alteraNomeClientePorId(id, clienteMatrizDto);
    }

}

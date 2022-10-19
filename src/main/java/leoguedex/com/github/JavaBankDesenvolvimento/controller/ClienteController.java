package leoguedex.com.github.JavaBankDesenvolvimento.controller;

import leoguedex.com.github.JavaBankDesenvolvimento.model.Cliente;
import leoguedex.com.github.JavaBankDesenvolvimento.model.Conta;
import leoguedex.com.github.JavaBankDesenvolvimento.model.dto.ClienteDTO;
import leoguedex.com.github.JavaBankDesenvolvimento.model.dto.ClienteRequestDTO;
import leoguedex.com.github.JavaBankDesenvolvimento.service.ClienteService;
import leoguedex.com.github.JavaBankDesenvolvimento.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ContaService contaService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.fromDtoCliente(clienteDTO);
        Conta conta = contaService.fromDtoConta(clienteDTO);
        cliente.setConta(conta);
        conta.setCliente(cliente);
        clienteService.inserir(cliente, conta);
        URI url = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(url).build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Cliente> buscaCliente(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscaCliente(id);
        return ResponseEntity.ok().body(cliente);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> buscarTodosClientes() {
        return clienteService.buscaTodosClientes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizaCliente(@PathVariable Integer id,
                                                @RequestBody ClienteRequestDTO cliDTO) {
        Cliente cliente = clienteService.atualizaPorDTO(cliDTO);
        cliente.setId(id);
        clienteService.atualizaCliente(cliente);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer id){
        clienteService.deletaCliente(id);
        return ResponseEntity.noContent().build();
    }

}

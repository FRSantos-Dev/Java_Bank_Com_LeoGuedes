package leoguedex.com.github.JavaBankDesenvolvimento.controller;

import leoguedex.com.github.JavaBankDesenvolvimento.model.Conta;
import leoguedex.com.github.JavaBankDesenvolvimento.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping(value = "/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Conta> buscaConta(@PathVariable Integer id) {
        Conta conta = contaService.buscaConta(id);
        return ResponseEntity.ok().body(conta);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletarConta(@PathVariable Integer id) {
        contaService.deletarConta(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/depositar/{id}/{valor}", method = RequestMethod.PUT)
    public ResponseEntity<String> depositar(@PathVariable Integer id, @PathVariable Double valor) {
        Conta conta = contaService.buscaConta(id);
        contaService.depositar(conta, valor);
        return ResponseEntity.ok().body("Saldo atualizado: " + conta.getSaldoAtual());
    }

    @RequestMapping(value = "/sacar/{id}/{valor}", method = RequestMethod.PUT)
    public ResponseEntity<String> sacar(@PathVariable Integer id, @PathVariable Double valor) {
        Conta conta = contaService.buscaConta(id);
        contaService.sacar(conta, valor);
        return ResponseEntity.ok().body("Saldo atualizado: " + conta.getSaldoAtual());
    }

    @RequestMapping(value = "/transferencia/{idOrigem}/{valor}/{idDestino}", method = RequestMethod.PUT)
    public void transferenciaEntreContas(@PathVariable Integer idOrigem,
                                         @PathVariable Double valor, @PathVariable Integer idDestino) {
        Conta contaOrigem = contaService.buscaConta(idOrigem);
        Conta contaDestino = contaService.buscaConta(idDestino);
        contaService.transferenciaEntreContas(contaOrigem, contaDestino, valor);
    }

    @RequestMapping(value = "/extratos/{id}", method = RequestMethod.GET)
    public List<String> obterExtratosPorId(@PathVariable Integer id){
        Conta conta = contaService.buscaConta(id);
        return conta.getExtratoBancario();
    }
}

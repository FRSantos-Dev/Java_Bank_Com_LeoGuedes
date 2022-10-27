package leoguedex.com.github.JavaBankDesenvolvimento.service;

import leoguedex.com.github.JavaBankDesenvolvimento.exceptions.DataIntegrityException;
import leoguedex.com.github.JavaBankDesenvolvimento.exceptions.ObjetoNaoEncontrado;
import leoguedex.com.github.JavaBankDesenvolvimento.model.Conta;
import leoguedex.com.github.JavaBankDesenvolvimento.model.dto.ClienteDTO;
import leoguedex.com.github.JavaBankDesenvolvimento.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta fromDtoConta(ClienteDTO clienteDTO) {
        return new Conta(
                0.0,
                clienteDTO.getTipoConta(),
                "Conta Criada no dia: " + LocalDate.now());
    }


    public Conta buscaConta(Integer id) {
        Optional<Conta> conta = contaRepository.findById(id);
        return conta.orElseThrow(
                () -> new ObjetoNaoEncontrado("Objeto não foi localizado, id:" + id + ", tipo: "
                        + Conta.class.getName()));
    }

    public void deletarConta(Integer id) {
        buscaConta(id);
        try {
            contaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma conta com dados associados");
        }
    }


    public void depositar(Conta conta, Double valor) {
        conta.setSaldoAtual(conta.getSaldoAtual() + valor);
        conta.setExtratoBancario(
                "Deposito de R$ " + valor + ", realizado no dia " + LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
        contaRepository.save(conta);
    }
}

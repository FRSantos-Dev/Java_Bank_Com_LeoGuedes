package leoguedex.com.github.JavaBankDesenvolvimento.service;

import leoguedex.com.github.JavaBankDesenvolvimento.model.Cliente;
import leoguedex.com.github.JavaBankDesenvolvimento.model.Conta;
import leoguedex.com.github.JavaBankDesenvolvimento.model.enums.TipoConta;
import leoguedex.com.github.JavaBankDesenvolvimento.repository.ClienteRepository;
import leoguedex.com.github.JavaBankDesenvolvimento.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DBService {

    public DBService() {
    }

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaService contaService;

    public void instanciaBancoDeDados() {

        Cliente cli1 = new Cliente(null, "Cliente 1", "71148923063", "cli1@gmail.com", "111111");
        Cliente cli2 = new Cliente(null, "Cliente 2", "48812435009", "cli2@gmail.com", "222222");
        Cliente cli3 = new Cliente(null, "Cliente 3", "59361542036", "cli3@gmail.com", "333333");

        clienteRepository.save(cli1);
        clienteRepository.save(cli2);
        clienteRepository.save(cli3);

        Conta conta1 = new Conta(0.0, TipoConta.CONTA_SALARIO.getCod(), "Conta criada no dia "
                + LocalDateTime.now(), cli1);
        Conta conta2 = new Conta(0.0, TipoConta.CONTA_SALARIO.getCod(), "Conta criada no dia "
                + LocalDateTime.now(), cli1);
        Conta conta3 = new Conta(0.0, TipoConta.CONTA_POUPANCA.getCod(), "Conta criada no dia "
                + LocalDateTime.now(), cli1);

        contaRepository.save(conta1);
        contaRepository.save(conta2);
        contaRepository.save(conta3);

        cli1.setConta(conta1);
        cli2.setConta(conta2);
        cli3.setConta(conta3);

        clienteRepository.save(cli1);
        clienteRepository.save(cli2);
        clienteRepository.save(cli3);

    }

}

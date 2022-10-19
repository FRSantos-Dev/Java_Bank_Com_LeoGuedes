package leoguedex.com.github.JavaBankDesenvolvimento.service;

import leoguedex.com.github.JavaBankDesenvolvimento.model.Conta;
import leoguedex.com.github.JavaBankDesenvolvimento.model.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {

    public Conta fromDtoConta(ClienteDTO clienteDTO){
        return new Conta(
                0.0,
                clienteDTO.getTipoConta(),
                "Conta Criada no dia: " + LocalDate.now());
    }
}

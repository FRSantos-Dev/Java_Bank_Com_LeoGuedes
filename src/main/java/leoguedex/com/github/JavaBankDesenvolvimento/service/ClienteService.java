package leoguedex.com.github.JavaBankDesenvolvimento.service;

import leoguedex.com.github.JavaBankDesenvolvimento.exceptions.DataIntegrityException;
import leoguedex.com.github.JavaBankDesenvolvimento.exceptions.ObjetoNaoEncontrado;
import leoguedex.com.github.JavaBankDesenvolvimento.model.Cliente;
import leoguedex.com.github.JavaBankDesenvolvimento.model.Conta;
import leoguedex.com.github.JavaBankDesenvolvimento.model.dto.ClienteDTO;
import leoguedex.com.github.JavaBankDesenvolvimento.model.dto.ClienteRequestDTO;
import leoguedex.com.github.JavaBankDesenvolvimento.repository.ClienteRepository;
import leoguedex.com.github.JavaBankDesenvolvimento.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    public Cliente fromDtoCliente(ClienteDTO clienteDTO) {
        return new Cliente().builder()
                .nome(clienteDTO.getNomeCompleto())
                .cpf(clienteDTO.getCpfUsuario())
                .email(clienteDTO.getEmailUsuario())
                .dataCadastro(LocalDate.now())
                .senha(clienteDTO.getSenhaUsuario())
                .build();
    }

    @Transactional
    public void inserir(Cliente cliente, Conta conta) {
        cliente.setId(null);
        conta.setId(null);
        clienteRepository.save(cliente);
        contaRepository.save(conta);
    }

    public Cliente buscaCliente(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(
                () -> new ObjetoNaoEncontrado("Cliente Não Encontrado "
                        + Cliente.class.getName())
        );
    }

    public List<Cliente> buscaTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente atualizaPorDTO(ClienteRequestDTO cliDTO) {
        return new Cliente(null,
                cliDTO.getNomeCompleto(),
                null,
                cliDTO.getEmailUsuario(),
                cliDTO.getSenhaUsuario(),
                null,
                null);
    }

    public void atualizaCliente(Cliente cliente) {
        Cliente clienteParaAtualizar = buscaCliente(cliente.getId());
        clienteParaAtualizar.setNome(cliente.getNome());
        clienteParaAtualizar.setEmail(cliente.getEmail());
        clienteParaAtualizar.setSenha(cliente.getSenha());
        clienteRepository.save(clienteParaAtualizar);
    }

    public void deletaCliente(Integer id) {
        buscaCliente(id);
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é Possivel Excluir Cliente com Dados");
        }

    }
}

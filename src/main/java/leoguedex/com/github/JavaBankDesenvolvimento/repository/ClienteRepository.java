package leoguedex.com.github.JavaBankDesenvolvimento.repository;

import leoguedex.com.github.JavaBankDesenvolvimento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

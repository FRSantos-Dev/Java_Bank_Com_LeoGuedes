package leoguedex.com.github.JavaBankDesenvolvimento.repository;

import leoguedex.com.github.JavaBankDesenvolvimento.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}

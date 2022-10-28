package leoguedex.com.github.JavaBankDesenvolvimento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;

    @Column(name = "cpf", length = 11)
    @CPF(message = "Favor inserir um CPF válido")
    @NotEmpty(message = "Campo CPF é obrigatório")
    private String cpf;

    @Column(name = "email")
    @Email(message = "Email invalido")
    private String email;

    @Column(name = "senha", length = 6)
    private String senha;

    @Column(name = "data_cadastro")
    //@Pattern(regexp = "dd/MM/yyyy HH:mm:ss")
    private LocalDate dataCadastro;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = LocalDate.now();
    }
}

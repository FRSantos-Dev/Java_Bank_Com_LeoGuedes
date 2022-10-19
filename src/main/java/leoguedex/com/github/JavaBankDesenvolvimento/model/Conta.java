package leoguedex.com.github.JavaBankDesenvolvimento.model;

import leoguedex.com.github.JavaBankDesenvolvimento.model.enums.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conta")
public class Conta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer agencia;

    private String numConta;

    private Double saldoAtual;

    private TipoConta tipoConta;

    private LocalDateTime dataCriacao;

    @ElementCollection
    @CollectionTable(name = "extrato")
    private List<String> extratoBancario = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    public Conta(Double saldoAtual, Integer numTipoConta, String extratoBancario, Cliente cliente) {
        Random random = new Random();
        this.saldoAtual = saldoAtual;
        this.tipoConta = TipoConta.toEnum(numTipoConta);
        this.extratoBancario.add(extratoBancario);
        this.dataCriacao = LocalDateTime.now();
        this.numConta = "" + random.nextInt(9999) + "." + random.nextInt(9999)
                + "." + random.nextInt(9999) + "." + random.nextInt(9999);
        this.agencia = random.nextInt(9999);
        this.cliente = cliente;
    }

    public Conta(Double saldoAtual, Integer numTipoConta, String extratoBancario) {
        Random random = new Random();
        this.saldoAtual = saldoAtual;
        this.tipoConta = TipoConta.toEnum(numTipoConta);
        this.extratoBancario.add(extratoBancario);
        this.dataCriacao = LocalDateTime.now();
        this.numConta = "" + random.nextInt(9999) + "." + random.nextInt(9999)
                + "." + random.nextInt(9999) + "." + random.nextInt(9999);
        this.agencia = random.nextInt(9999);
    }

    public void setExtratoBancario(String extratoBancario) {
        this.extratoBancario.add(extratoBancario);
    }

}

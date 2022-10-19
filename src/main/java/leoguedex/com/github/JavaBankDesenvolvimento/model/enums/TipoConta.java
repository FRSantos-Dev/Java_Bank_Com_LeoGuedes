package leoguedex.com.github.JavaBankDesenvolvimento.model.enums;

public enum TipoConta {

    CONTA_SALARIO(0, "Conta Salario"),
    CONTA_CORRENTE(1, "Conta Corrente"),
    CONTA_POUPANCA(2, "Conta Poupança");

    private Integer cod;
    private String descricao;

    TipoConta(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public static TipoConta toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }


        for (TipoConta variavelLocalizada : TipoConta.values()) {
            if (codigo.equals(variavelLocalizada.getCod())) {
                return variavelLocalizada;
            }
        }

        throw new IllegalArgumentException("Tipo de Conta Invalido: " + codigo);
    }


}

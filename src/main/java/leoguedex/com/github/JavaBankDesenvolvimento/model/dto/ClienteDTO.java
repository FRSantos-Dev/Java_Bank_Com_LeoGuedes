package leoguedex.com.github.JavaBankDesenvolvimento.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotEmpty(message = "Campo nome é obrigatório")
    private String nomeCompleto;

    @NotEmpty(message = "Campo CPF é obrigatório")
    private String cpfUsuario;

    private String emailUsuario;

    private String senhaUsuario;

    private Integer tipoConta;

}

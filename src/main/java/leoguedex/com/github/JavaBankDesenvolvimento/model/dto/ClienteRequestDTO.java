package leoguedex.com.github.JavaBankDesenvolvimento.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteRequestDTO {

    private String nomeCompleto;

    private String emailUsuario;

    private String senhaUsuario;

}

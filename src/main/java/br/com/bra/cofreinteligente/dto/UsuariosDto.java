package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDto implements Serializable {
    @Size(min = 6, max = 7)
    private Long funcional;

    private String senha;
    private String nome;

    private String acesso;

    public UsuariosDto(Usuarios usuarios) {
        this.funcional = usuarios.getFuncional();
        this.nome = usuarios.getNome();
        this.acesso = usuarios.getAcesso();
        this.senha = usuarios.getSenha();
    }
}
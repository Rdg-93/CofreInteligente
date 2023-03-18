package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    UserDetails findByFuncional(long parseLong);
}
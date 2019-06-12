package br.com.sebo.pojo;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Role implements GrantedAuthority {
    @Id
    private String role;
    @OneToMany
    private List<Usuario> usuarios;

    public Role() {
    }

    public Role(String role, List<Usuario> usuarios) {
        this.role = role;
        this.usuarios = usuarios;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}

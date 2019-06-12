package br.com.sebo;

import br.com.sebo.pojo.Livro;
import br.com.sebo.pojo.Role;
import br.com.sebo.pojo.Usuario;
import br.com.sebo.repository.LivroRepository;
import br.com.sebo.repository.RoleRepository;
import br.com.sebo.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SeboApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeboApplication.class, args);
    }

    @Bean
    CommandLineRunner init(LivroRepository repository, UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
        return args -> {

            Livro l1 = new Livro("A menina que roubava livros", "1991", "Fantasia");
            Livro l2 = new Livro("O guia do mochileiro das galáxias", "1995", "Fantasia");
            Livro l3 = new Livro("Spring Boot Book", "2017", "Tecnico");
            repository.save(l1);
            repository.save(l2);
            repository.save(l3);

            Role r1 = new Role("ADMIN",null);
            Role r2 = new Role("USER",null);
            Usuario u1 = new Usuario("admin","administrador","12345", Arrays.asList(r1));
            Usuario u2 = new Usuario("user","usuario","user123", Arrays.asList(r2));

            roleRepository.save(r1);
            roleRepository.save(r2);

            usuarioRepository.save(u1);
            usuarioRepository.save(u2);
        };
    }
}

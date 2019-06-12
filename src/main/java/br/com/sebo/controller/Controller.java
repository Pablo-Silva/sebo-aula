package br.com.sebo.controller;

import br.com.sebo.pojo.Livro;
import br.com.sebo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller extends ResponseEntityExceptionHandler {

    @Autowired
    public LivroRepository repository;

    @PostMapping("livros")
    public Livro salvar(@Valid @RequestBody Livro livro){
        return repository.save(livro);
    }

    @PutMapping("livros")
    public Livro atualizar(@Valid @RequestBody Livro livro){
        return repository.save(livro);
    }

    @DeleteMapping("livros/{id}")
    public void excluir(@Valid @PathVariable Long id){
        repository.deleteById(id);
    }

    @DeleteMapping("livros")
    public void excluir(@Valid @RequestBody Livro livro){
        repository.delete(livro);
    }

    @GetMapping("livros")
    public List<Livro> getLivros(){
        return repository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("livros/{id}")
    public Optional<Livro> getLivro(@Valid @PathVariable Long id){ return repository.findById(id);
    }

    @GetMapping("livros/ano/{ano}")
    public List<Livro> getLivro(@Valid @PathVariable String ano){
        return repository.findAllByAno(ano);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleException(HttpServletRequest req, Exception e){
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(e.getMessage());
    }
}
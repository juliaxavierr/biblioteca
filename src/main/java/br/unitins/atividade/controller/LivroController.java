package br.unitins.atividade.controller;

import br.unitins.atividade.model.Livro;
import br.unitins.atividade.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroService livroService;

    @Autowired
    public void livroController(LivroService livroService) {
        this.livroService = livroService;
    }

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        Livro createdLivro = livroService.createLivro(livro);
        return new ResponseEntity<>(createdLivro, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros() {
        List<Livro> livros = livroService.getAllLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }
}
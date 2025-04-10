package br.unitins.atividade.service;

import br.unitins.atividade.model.Livro;
import br.unitins.atividade.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro createLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }
}
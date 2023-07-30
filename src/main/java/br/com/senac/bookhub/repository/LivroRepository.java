package br.com.senac.bookhub.repository;

import br.com.senac.bookhub.model.Livro;

import java.util.List;

public interface LivroRepository {
    List<Livro> listarLivros();
    void adicionarLivro(Livro livro);
    void atualizarLivro(Livro livro);
    void excluirLivro(int id);
    List<Livro> pesquisarLivro(String termo);
}
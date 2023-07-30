package br.com.senac.bookhub.service;

import br.com.senac.bookhub.model.Livro;
import br.com.senac.bookhub.repository.JdbcLivroRepository;
import br.com.senac.bookhub.repository.LivroRepository;

import java.util.List;

public class LivroService {
 private final LivroRepository livroRepository;

 public LivroService() {
  livroRepository = new JdbcLivroRepository(); // Inicializa a implementação do Repository (JdbcLivroRepository)
 }

 public List<Livro> listarLivros() {
  return livroRepository.listarLivros();
 }

 public void adicionarLivro(Livro livro) {
  livroRepository.adicionarLivro(livro);
 }

 public void atualizarLivro(Livro livro) {
  livroRepository.atualizarLivro(livro);
 }

 public void excluirLivro(int id) {
  livroRepository.excluirLivro(id);
 }

 public List<Livro> pesquisarLivro(String termo) {
  return livroRepository.pesquisarLivro(termo);
 }
}

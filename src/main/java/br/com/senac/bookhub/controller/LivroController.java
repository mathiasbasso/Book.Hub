package br.com.senac.bookhub.controller;

import br.com.senac.bookhub.model.Livro;
import br.com.senac.bookhub.service.LivroService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class LivroController {
    @FXML
    private TextField nomeLivroField;
    @FXML
    private TextField autorField;
    @FXML
    private TextField precoField;
    @FXML
    private TableView<Livro> livrosTableView;
    @FXML
    private TableColumn<Livro, String> nomeLivroColumn;
    @FXML
    private TableColumn<Livro, String> autorColumn;
    @FXML
    private TableColumn<Livro, Double> precoColumn;
    @FXML
    private TextField pesquisaField;

    private final LivroService livroService = new LivroService();

    private Livro livroSelecionado;

    @FXML
    private void adicionarLivro() {
        String nomeLivro = nomeLivroField.getText();
        String autor = autorField.getText();
        double preco = Double.parseDouble(precoField.getText());

        Livro livro = new Livro();
        livro.setNomeLivro(nomeLivro);
        livro.setAutor(autor);
        livro.setPreco(preco);

        livroService.adicionarLivro(livro);
        listarLivros();
        limparCampos();
    }

    @FXML
    private void atualizarLivro() {
        if (livroSelecionado != null) {
            String nomeLivro = nomeLivroField.getText();
            String autor = autorField.getText();
            double preco = Double.parseDouble(precoField.getText());

            livroSelecionado.setNomeLivro(nomeLivro);
            livroSelecionado.setAutor(autor);
            livroSelecionado.setPreco(preco);

            livroService.atualizarLivro(livroSelecionado);
            listarLivros();
            limparCampos();
        }
    }

    @FXML
    private void excluirLivro() {
        if (livroSelecionado != null) {
            livroService.excluirLivro(livroSelecionado.getId());
            listarLivros();
            limparCampos();
        }
    }

    @FXML
    private void pesquisarLivros() {
        String termoPesquisa = pesquisaField.getText();
        List<Livro> livrosEncontrados = livroService.pesquisarLivro(termoPesquisa);

        livrosTableView.getItems().clear();
        livrosTableView.getItems().addAll(livrosEncontrados);
    }

    private void listarLivros() {
        List<Livro> livros = livroService.listarLivros();

        livrosTableView.getItems().clear();
        livrosTableView.getItems().addAll(livros);
    }

    private void limparCampos() {
        nomeLivroField.clear();
        autorField.clear();
        precoField.clear();
    }

    @FXML
    private void initialize() {
        nomeLivroColumn.setCellValueFactory(new PropertyValueFactory<>("nomeLivro"));
        autorColumn.setCellValueFactory(new PropertyValueFactory<>("autor"));
        precoColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));

        livrosTableView.getSelectionModel().selectedItemProperty().addListener((obs, antigoLivro, novoLivro) -> {
            livroSelecionado = novoLivro;
            if (novoLivro != null) {
                nomeLivroField.setText(novoLivro.getNomeLivro());
                autorField.setText(novoLivro.getAutor());
                precoField.setText(String.valueOf(novoLivro.getPreco()));
            }
        });

    }
}


package br.com.senac.bookhub.model;

public class Livro {
    private String autor;
    private String nomeLivro;
    private double preco;
    private int id;

    public Livro() {

    }

    public static Object getNewInstance() {

        return null;
    }

    // Métodos getters e setters
    public String getAutor() {

        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
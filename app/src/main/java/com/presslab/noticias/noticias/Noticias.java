package com.presslab.noticias.noticias;


//classe que popula os itens na minha listview
public class Noticias {
    private int id;
    private String noticia;
    private String titulo;
    private int imagem;

    public Noticias(int id, int imagem, String titulo, String noticia) {
        this.id = id;
        this.imagem = imagem;
        this.titulo = titulo;
        this.noticia = noticia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }
}



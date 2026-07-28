package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Episodio")
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episodio_id")
    private Integer episodioId;

    @Column(name = "numero_episodio")
    private Integer numeroEpisodio;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "temporada_id")
    private Temporada temporada;

    public Integer getEpisodioId() {
        return episodioId;
    }

    public void setEpisodioId(Integer episodioId) {
        this.episodioId = episodioId;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
}

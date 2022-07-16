package main.java.br.projeto;

public class Anime {
    private String nome;
    private String tipo;
    private int episodios;

    private String DubladoOuLegendado;
    private String Gênero;
    private int classificação;
    private int temporadas;

    public Anime() {
        this("", "", 0, "", "", 0, 0);
    }

    public Anime(String nome, String tipo, int episodios, String DubladoOuLegendado, String Gênero, int Classificação,
            int temporadas) {
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
        this.DubladoOuLegendado = DubladoOuLegendado;
        this.Gênero = Gênero;
        this.classificação = Classificação;
        this.temporadas = temporadas;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEpisodios() {
        return episodios;
    }

    public String getDubladoOuLegendado() {
        return DubladoOuLegendado;
    }

    public String getGênero() {
        return Gênero;
    }

    public int getClassificação() {
        return classificação;
    }

    public int gettemporadas() {
        return temporadas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public void setDubladoOuLegendado(String dubladoOuLegendado) {
        DubladoOuLegendado = dubladoOuLegendado;
    }

    public void setGênero(String gênero) {
        Gênero = gênero;
    }

    public void setClassificação(int classificação) {
        this.classificação = classificação;
    }

    public void setTemporada(int temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Anime other = (Anime) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

}

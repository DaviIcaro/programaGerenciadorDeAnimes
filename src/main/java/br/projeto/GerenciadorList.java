package main.java.br.projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorList implements GerenciadorInterface {

    private List<Anime> animes;
    private GravadorDeDados gravador;

    private List<Anime> animesEMangá;

    public GerenciadorList() {
        this.animesEMangá = new ArrayList<Anime>();
        this.gravador = new GravadorDeDados("Animes.txt");
        this.animes = new ArrayList<Anime>();
    }

    @Override
    public boolean cadastrarAnimesOrMangá(Anime animesOrMangá) throws AnimeJaExisteteException {
        if (animesEMangá.contains(animesOrMangá)) {
            throw new AnimeJaExisteteException("anime já existente");
        } else {
            animesEMangá.add(animesOrMangá);
        }
        return true;
    }

    @Override
    public boolean apagarAnimes(String nomeAnime, String TipoAnime) {
        for (Anime c : this.animesEMangá) {
            if (c.getNome().equals(nomeAnime) && c.getTipo().equals(TipoAnime)) {
                animesEMangá.remove(c);
                return true;
            } else {
                System.out.println("Anime não encontrado");
            }
        }
        return false;
    }

    @Override
    public List<Anime> getNome() {
        return animesEMangá;
    }

    @Override
    public void salvarDados() throws IOException {
        List<String> texto = new ArrayList<>();
        for (Anime c : this.animesEMangá) {
            String linha = c.getNome() + "#" + c.getTipo() + "#" + c.getEpisodios() + "#" + c.getDubladoOuLegendado()
                    + "#" + c.getGênero()
                    + "#" + c.getClassificação() + "#" + c.gettemporadas();
            texto.add(linha);
        }
        this.gravador.gravaTexto(texto);
    }

    @Override
    public void recuperarDados() throws IOException {
        List<String> texto = this.gravador.recuperarDadosPerdidos();
        for (String linha : texto) {
            String[] dados = linha.split("#");
            Anime c = new Anime(dados[0], dados[1], Integer.parseInt(dados[2]), dados[3], dados[4],
                    Integer.parseInt(dados[5]), Integer.parseInt(dados[6]));
            this.animesEMangá.add(c);
        }
    }

    @Override
    public ArrayList<Anime> pesquisarAnimesPorTipo(String tipo) {
        ArrayList<Anime> animesAchados = new ArrayList<>();
        for (Anime c : this.animesEMangá) {
            if (c.getTipo().equals(tipo)) {
                animesAchados.add(c);
            }
        }
        return animesAchados;
    }

    @Override
    public ArrayList<Anime> pesquisarAnimesPorAudio(String DubladoOuLegendado) {
        ArrayList<Anime> animesAchados = new ArrayList<>();
        for (Anime c : this.animesEMangá) {
            if (c.getDubladoOuLegendado().equals(DubladoOuLegendado)) {
                animesAchados.add(c);
            }
        }
        return animesAchados;
    }
}

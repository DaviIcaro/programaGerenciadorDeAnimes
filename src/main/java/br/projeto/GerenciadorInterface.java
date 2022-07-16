package main.java.br.projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface GerenciadorInterface {

    public boolean cadastrarAnimesOrMangá(Anime animesOrMangá) throws AnimeJaExisteteException;

    public boolean apagarAnimes(String nomeAnime, String TipoAnime);

    public ArrayList<Anime> pesquisarAnimesPorTipo(String tipo);

    public ArrayList<Anime> pesquisarAnimesPorAudio(String DubladoOuLegendado);

    public List<Anime> getNome();

    public void salvarDados() throws IOException;

    public void recuperarDados() throws IOException;

}

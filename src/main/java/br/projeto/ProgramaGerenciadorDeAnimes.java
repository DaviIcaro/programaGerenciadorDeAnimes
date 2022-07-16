package main.java.br.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ProgramaGerenciadorDeAnimes {

    public static void main(String[] args) {

        GerenciadorInterface animesEMangá = new GerenciadorList();

        boolean continuar = true;
        try {
            animesEMangá.recuperarDados();
            System.out.println("Dados Recuperados com Sucesso!");
        } catch (IOException e1) {
            System.out.println(
                    "Houve problemas ao recuperar os dados salvos de anime. Detalhes: " +
                            e1.getMessage());
        }
        while (continuar) {
            System.out.print(
                    "\n   1 -  Cadastrar( Anime ) \n"
                            +
                            "   2 -  Apagar Anime \n" +
                            "   3 -  Listar Todos os animes \n" +
                            "   4 -  Pesquisa os animes cadastrados Audio [Dublado] ou [Legendado]\n" +
                            "   5 -  Pesquisa os animes cadastrados por tipo\n" +
                            "   6 -  Sair\n   Digite a opção desejada: ");

            int opcao;
            Scanner sc = new Scanner(System.in);
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("Você deseja iniciar o cadastro? [Sim/Nao] ");
                    String op = sc.nextLine();
                    if (op.equalsIgnoreCase("Sim")) {

                        String nome = JOptionPane.showInputDialog("\n Qual é o nome do Anime ?");
                        String tipo = JOptionPane.showInputDialog("\n Digite Qual é o tipo do Anime ?");
                        int eps = Integer
                                .parseInt(JOptionPane.showInputDialog("\n Digite qual é a quantidade de episodios ?"));
                        String DubladoOuLegendado = JOptionPane
                                .showInputDialog("\n o O anime estar Dublado Ou Lengendado ?");
                        String Genero = JOptionPane.showInputDialog("\n Digite Qual é o gênero do Anime ?");
                        int classificacao = Integer
                                .parseInt(JOptionPane
                                        .showInputDialog("\n Digite qual é a classificação do Anime ?"));
                        int temporadas = Integer.parseInt(JOptionPane
                                .showInputDialog("\n Digite qual a é quantidade de temporadas ?"));

                        Anime animesOrMangá = new Anime(nome, tipo, eps, DubladoOuLegendado, Genero, classificacao,
                                temporadas);
                        try {
                            animesEMangá.cadastrarAnimesOrMangá(animesOrMangá);
                        } catch (AnimeJaExisteteException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Digite o Nome do anime que você deseja apagar\n");
                    String nomeAnime = sc.nextLine();
                    System.out.println("Digite o tipo do anime que você deseja apagar\n");
                    String TipoAnime = sc.nextLine();

                    if (animesEMangá.apagarAnimes(nomeAnime, TipoAnime)) {
                        System.out.println("O anime foi apagado com sucesso!");
                    } else {
                        System.out.println(
                                "Não foi possível apagar o anime! Verifique se você digitou algo errado e tente novamente.");
                    }
                    break;
                case 3:
                    for (Anime c : animesEMangá.getNome()) {
                        System.out.println(c.getNome());
                    }
                    break;
                case 4:
                    System.out.print("Digite se você quer animes [Dublado] ou [Legendado]");
                    String DubladoOuLegendado = sc.nextLine();
                    ArrayList<Anime> animesAchadosporAudio = animesEMangá.pesquisarAnimesPorAudio(DubladoOuLegendado);
                    for (Anime c : animesAchadosporAudio) {
                        System.out.println(c.getNome());
                    }
                    break;
                case 5:
                    System.out.println("Digite o nome do Tipo de anime que voce deseja pesquisa? Por exemplo: Filme ");
                    String tipoAPesquisar = sc.nextLine();
                    ArrayList<Anime> animesAchados = animesEMangá.pesquisarAnimesPorTipo(tipoAPesquisar);
                    for (Anime c : animesAchados) {
                        System.out.println(c.getNome());
                    }
                    break;

                case 6:
                    continuar = false;
                    try {
                        animesEMangá.salvarDados();
                        System.out.println("Dados Salvos com sucesso");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Opção invalida, tente novamente!");
                    break;
            }
        }
    }

}

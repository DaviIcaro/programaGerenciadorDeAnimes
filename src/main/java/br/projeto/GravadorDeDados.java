package main.java.br.projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GravadorDeDados {
    private String NomeDoArquivo;

    public GravadorDeDados(String NomeDoArquivo) {
        this.NomeDoArquivo = NomeDoArquivo;
    }

    public void gravaTexto(List<String> texto) throws IOException {
        BufferedWriter gravador = null;

        try {
            gravador = new BufferedWriter(new FileWriter(this.NomeDoArquivo));
            for (String c : texto) {
                gravador.write(c + "\n");
            }
        } finally {
            if (gravador != null) {
                gravador.close();
            }
        }
    }

    public List<String> recuperarDadosPerdidos() throws IOException {
        List<String> textoLido = new LinkedList<>();
        BufferedReader leitor = null;

        try {
            leitor = new BufferedReader(new FileReader(this.NomeDoArquivo));
            String linha = null;

            do {
                linha = leitor.readLine();
                if (linha != null) {
                    textoLido.add(linha);
                }
            } while (linha != null);
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
        return textoLido;
    }
}

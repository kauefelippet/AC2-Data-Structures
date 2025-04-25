package main;

import models.*;

import javax.swing.JOptionPane;
import java.util.jar.JarOutputStream;

/**
 * @author Kauê Felippe Tiburcio - RA 247721
 * Centro Universitário FACENS - 2025
 */
public class AC2Parte2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEncadeada listaReproducao = new ListaEncadeada();
        ListaDupla historico = new ListaDupla();

        do {
            String[] options = {
                    "Adicionar música à fila",
                    "Tocar próxima música",
                    "Ver fila de reprodução",
                    "Ver música atual",
                    "Ver histórico",
                    "Navegar histórico",
                    "Sair"
            };

            int opcao = JOptionPane.showOptionDialog(
                    null,
                    "🎵 Estação de Rádio - Sistema de Playback\n\n" +
                            "Escolha uma opção:",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (opcao) {
                case 0 -> {
                    String titulo = JOptionPane.showInputDialog("Título da música:");
                    String artista = JOptionPane.showInputDialog("Artista:");
                    int duracao;
                    try {
                        duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração (segundos):"));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Duração inválida.");
                        break;
                    }
                    listaReproducao.adicionarMusica(titulo, artista, duracao);
                }

                case 1 -> listaReproducao.tocarProximaMusica(historico);

                case 2 ->
                        JOptionPane.showMessageDialog(null, "Fila de reprodução (Próximas):\n" + listaReproducao.exibeLista());

                case 3 -> {
                    try {
                        JOptionPane.showMessageDialog(null, "Música atual:\n" + historico.getUltimo().getMusica());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não há músicas tocando no momento.");
                    }
                }

                case 4 -> JOptionPane.showMessageDialog(null, historico.ExibeLista());

                case 5 -> {
                    String escolha = JOptionPane.showInputDialog("Digite [A] para anterior ou [P] para próxima:");
                    if (escolha != null) {
                        historico.navegarHistorico(listaReproducao, escolha);
                    }
                }

                case 6 -> {
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                    return;
                }

                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (true);
    }
}
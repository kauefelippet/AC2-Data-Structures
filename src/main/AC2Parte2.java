package main;

import models.ListaDupla;
import models.ListaEncadeada;
import models.Musica;

import javax.swing.JOptionPane;

/**
 *
 * @author Kauê Felippe Tiburcio - RA 247721
 *         Centro Universitário FACENS - 2025
 * */
public class AC2Parte2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEncadeada ListaReproducao = new ListaEncadeada();
        ListaDupla historico = new ListaDupla();

        int opcao;

        do {
            String menu = """
                🎵 Estação de Rádio - Sistema de Playback

                1. Adicionar música à fila
                2. Tocar próxima música
                3. Ver fila de reprodução
                4. Ver música atual
                5. Navegar histórico
                0. Sair

                Escolha uma opção:
                """;

            try {
                String input = JOptionPane.showInputDialog(menu);
                if (input == null) break; // Usuário clicou em cancelar
                opcao = Integer.parseInt(input);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!");
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    String titulo = JOptionPane.showInputDialog("Título da música:");
                    String artista = JOptionPane.showInputDialog("Artista:");
                    int duracao;
                    try {
                        duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração (segundos):"));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Duração inválida.");
                        break;
                    }

                    Musica nova = new Musica(titulo, artista, duracao);
                    // TODO: Adicionar à fila
                    JOptionPane.showMessageDialog(null, "Música adicionada à fila!");
                }

                case 2 -> {
                    // TODO: Tocar próxima música
                    // Exemplo: JOptionPane.showMessageDialog(null, "Tocando: " + musica.toString());
                }

                case 3 -> {
                    // TODO: Listar músicas na Lista de Reproducao
                    // Exemplo: JOptionPane.showMessageDialog(null, "Fila:\n" + fila.listar());
                }

                case 4 -> {
                    // TODO: Mostrar música atual
                }

                case 5 -> {
                    String escolha = JOptionPane.showInputDialog("Digite [A] para anterior ou [P] para próxima:");
                    if (escolha == null) break;

                    if (escolha.equalsIgnoreCase("A")) {
                        // TODO: ir para anterior
                    } else if (escolha.equalsIgnoreCase("P")) {
                        // TODO: ir para próxima
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                    }
                }

                case 0 -> JOptionPane.showMessageDialog(null, "Encerrando o sistema...");

                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (true);
    }
    }

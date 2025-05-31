package br.library.sp.libgames.view;
import br.library.sp.libgames.dao.JogosDao;
import br.library.sp.libgames.dao.ConnectionFactory;
import br.library.sp.libgames.enumeration.Plataforma;
import br.library.sp.libgames.enumeration.Status;
import br.library.sp.libgames.model.Jogos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class ViewLib {
    static Scanner scanner = new Scanner(System.in);
    static JogosDao dao;

    public static void main(String[] args) throws SQLException {
        try {
            Connection conexao = ConnectionFactory.getConexao();
            dao = new JogosDao(conexao);
        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco: " + e.getMessage());
            return;
        }

        int opcao;
        do {
            System.out.println("\nx-x-x BEM VINDO A BIBLIOTECA DE JOGOS (NEW ERA GAMES) x-x-x");
            System.out.println("1 - Cadastrar um novo jogo");
            System.out.println("2 - Listar jogos disponiveis");
            System.out.println("3 - Atualizar jogo");
            System.out.println("4 - Excluir jogo");
            System.out.println("0 - Sair do sistema");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarJogo();
                    break;
                case 2:
                    exibirJogos();
                    break;
                case 3:
                    atualizarJogo();
                    break;
                case 4:
                    excluirJogo();
                    break;
            }
        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }

    static void cadastrarJogo() {
        try {
            Jogos jogo = new Jogos();

            System.out.print("Nome: ");
            jogo.setNome(scanner.nextLine());

            System.out.println("Plataforma:");
            for (Plataforma p : Plataforma.values()) {
                System.out.println(p.ordinal() + " - " + p);
            }
            jogo.setPlataforma(Plataforma.values()[Integer.parseInt(scanner.nextLine())]);

            System.out.print("Gênero: ");
            jogo.setGenero(scanner.nextLine());

            System.out.print("Nota (de 0 a 10): ");
            jogo.setNota(Double.parseDouble(scanner.nextLine()));

            System.out.print("Desenvolvedora: ");
            jogo.setDesenvolvedora(scanner.nextLine());

            System.out.println("Status:");
            for (Status s : Status.values()) {
                System.out.println(s.ordinal() + " - " + s);
            }
            jogo.setStatus(Status.values()[Integer.parseInt(scanner.nextLine())]);

            dao.inserir(jogo);
            System.out.println("🎮 Jogo salvo com sucesso!");

        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar jogo : " + e.getMessage());
        }
    }

    static void exibirJogos() throws SQLException {
        List<Jogos> jogos = dao.listar();
        System.out.println("\n🎮-x-x-x MINHA BIBLIOTECA DE JOGOS x-x-x-🎮");

        if (jogos.isEmpty()) {
            System.out.println("📭 Nenhum jogo cadastrado.");
        } else {
            for (Jogos j : jogos) {
                System.out.println("--------------------------------------------");
                System.out.println("🆔 ID: " + j.getID());
                System.out.println("🎮 Nome: " + j.getNome());
                System.out.println("🕹️ Plataforma: " + j.getPlataforma());
                System.out.println("🎲 Gênero: " + j.getGenero());
                System.out.println("⭐ Nota: " + j.getNota());
                System.out.println("🏢 Desenvolvedora: " + j.getDesenvolvedora());
                System.out.println("📌 Status: " + j.getStatus());
                System.out.println("--------------------------------------------\n");
            }
        }
    }
    static void atualizarJogo() {
        try {
            exibirJogos();
            System.out.print("Digite o ID do jogo que você deseja atualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            Jogos jogo = dao.buscar(id);
            if (jogo == null) {
                System.out.println("Jogo não encontrado.");
                return;
            }

            System.out.println("Atualizando jogo: " + jogo.getNome());

            System.out.print("Novo nome (" + jogo.getNome() + "): ");
            jogo.setNome(scanner.nextLine());

            System.out.println("Nova plataforma (" + jogo.getPlataforma() + "): ");
            for (Plataforma p : Plataforma.values()) {
                System.out.println(p.ordinal() + " - " + p);
            }
            jogo.setPlataforma(Plataforma.values()[Integer.parseInt(scanner.nextLine())]);

            System.out.print("Novo gênero (" + jogo.getGenero() + "): ");
            jogo.setGenero(scanner.nextLine());

            System.out.print("Nova nota (" + jogo.getNota() + "): ");
            jogo.setNota(Double.parseDouble(scanner.nextLine()));

            System.out.print("Nova desenvolvedora (" + jogo.getDesenvolvedora() + "): ");
            jogo.setDesenvolvedora(scanner.nextLine());

            System.out.println("Novo status (" + jogo.getStatus() + "): ");
            for (Status s : Status.values()) {
                System.out.println(s.ordinal() + " - " + s);
            }
            jogo.setStatus(Status.values()[Integer.parseInt(scanner.nextLine())]);

            dao.alterar(jogo);
            System.out.println("Jogo atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar jogo: " + e.getMessage());
        }
    }

    static void excluirJogo() {
        try {
            exibirJogos();
            System.out.print("Digite o ID do jogo que vc quer excluir: ");
            int id = Integer.parseInt(scanner.nextLine());
            dao.excluir(id);
            System.out.println("Jogo excluído com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao excluir o jogo seleciionado: " + e.getMessage());
        }
    }
}

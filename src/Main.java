import dominio.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Definição dos cursos e mentorias fixos
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso do Vasco");
        curso1.setDescricao("é isso mesmo");
        curso1.setCargaHoraria(80);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Vascainos Mentoria");
        mentoria1.setDescricao("é isso mesmo");
        mentoria1.setData(LocalDate.now());

        // Definição do Bootcamp fixo
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Java Bootcamp");
        bootcamp.setDescricao("Imagine uma boa descrição Java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria1);

        // Scanner para capturar entradas do usuário
        Scanner scanner = new Scanner(System.in);

        Set<Dev> devs = new HashSet<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite o nome do Dev:");
            String nomeDev = scanner.nextLine();

            Dev dev = new Dev();
            dev.setNome(nomeDev);
            dev.inscreverBootcamp(bootcamp);
            devs.add(dev);

            System.out.println("Dev " + nomeDev + " inscrito no " + bootcamp.getNome());

            boolean progresso = true;
            while (progresso) {
                System.out.println("Digite 1 para progredir em um conteúdo, 2 para ver conteúdo inscrito, 3 para ver conteúdo concluído, 4 para sair:");
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        dev.progredir();
                        System.out.println("Você progrediu no conteúdo.");
                        break;
                    case 2:
                        System.out.println("Conteúdos inscritos: " + dev.getConteudosInscritos());
                        break;
                    case 3:
                        System.out.println("Conteúdos concluídos: " + dev.getConteudosConcluidos());
                        System.out.println("XP Total: " + dev.calcularTotalXp());
                        break;
                    case 4:
                        progresso = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }

            System.out.println("Deseja adicionar outro Dev? (s/n)");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        // Exibir todos os devs e suas informações
        System.out.println("--------------");
        System.out.println("DEVS INSCRITOS");
        for (Dev dev : devs) {
            System.out.println("--------------");
            System.out.println("Dev: " + dev.getNome());
            System.out.println("Conteúdos Inscritos: " + dev.getConteudosInscritos());
            System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos());
            System.out.println("XP Total: " + dev.calcularTotalXp());
            System.out.println("--------------");
        }
        scanner.close();
    }
}
import dominio.*;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso do vasco");
        curso1.setDescricao("é isso mesmo");
        curso1.setCargaHoraria(80);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("vascainos mentoria");
        mentoria1.setDescricao("é isso mesmo");
        mentoria1.setData(LocalDate.now());

        System.out.println(curso1);
        System.out.println(mentoria1);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Java bootcamp");
        bootcamp.setDescricao("Imagine uma boa descrição java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria1);

        Devs devGuibas = new Devs();
        devGuibas.setNome("guibas");
        devGuibas.inscreverBootcamp(bootcamp);
        System.out.println("conteudos incritos guibas: " + devGuibas.getConteudosInscritos());
        devGuibas.progredir();
        System.out.println("-");
        System.out.println("conteudos incritos guibas: " + devGuibas.getConteudosInscritos());
        System.out.println("conteudos concluidos guibas: " + devGuibas.getConteudosConcluidos());
        System.out.println("XP: " + devGuibas.calcularTotalXp());

        System.out.println("--------------");

        Devs devBaguis = new Devs();
        devBaguis.setNome("baguis");
        devBaguis.inscreverBootcamp(bootcamp);
        System.out.println("conteudos incritos baguis: " + devBaguis.getConteudosInscritos());
        devBaguis.progredir();
        System.out.println("-");
        System.out.println("conteudos incritos baguis: " + devBaguis.getConteudosInscritos());
        System.out.println("conteudos concluidos baguis: " + devGuibas.getConteudosConcluidos());
        System.out.println("XP: " + devBaguis.calcularTotalXp());
    }
}
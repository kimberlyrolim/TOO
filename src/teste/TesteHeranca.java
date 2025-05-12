/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

/**
 *
 * @author 20182PF.CC0076
 */
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Aluno;
import modelo.AvaliacaoFisica;
import modelo.Professor;
import modelo.Plano;

public class TesteHeranca {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));

        Professor p = new Professor();
        p.setNome("Juka");
        p.setCpf("123.123.123-67");
        p.setEspecializacao("Musculação");

        //System.out.println(p.exibirDados());

        Plano p1 = new Plano("Premium", "Acesso Total", 150.00);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Aluno a1 = new Aluno();
        a1.setNome("João (com desconto)");
        a1.setMatricula("10035");
        a1.setDataMatricula(LocalDate.parse("01/01/2025", formato));
        a1.setPlano(p1);
        a1.verificaDesconto();

        Aluno a2 = new Aluno();
        a2.setNome("Maria (sem desconto)");
        a2.setMatricula("10040");
        a2.setDataMatricula(LocalDate.parse("12/05/2025", formato));
        a2.setPlano(p1);
        a2.verificaDesconto();

        AvaliacaoFisica av1 = new AvaliacaoFisica(a1);
        AvaliacaoFisica av2 = new AvaliacaoFisica(a2);

        a1.adicionarAvaliacao(av1);
        a2.adicionarAvaliacao(av2);

        System.out.println(a1.exibirDados());
        System.out.println(a2.exibirDados());

    }
}
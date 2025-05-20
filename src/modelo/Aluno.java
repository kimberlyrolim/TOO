/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 20182PF.CC0076
 */
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{
    protected String matricula;
    protected List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
    protected Plano plano;
    protected double valorMensalidade;
    protected LocalDate dataMatricula;

    public void adicionarAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

   @Override
public String exibirDados() {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    String aux = "....... Dados do Aluno(a) .......\n";
    aux += "Nome: " + getNome() + "\n";
    aux += "\nMatrícula: " + getMatricula();

    if (dataMatricula != null) {
        aux += "\nData de Matrícula: " + formato.format(dataMatricula);
    }

    if (plano != null) {
        aux += "\nPlano: " + plano.getNome() + " - R$ " + String.format("%.2f", plano.getValor());
    }
   if (!(this instanceof AlunoConvenio)) {
        aux += "\nValor total a ser pago: R$ " + String.format("%.2f", valorMensalidade);
    }
    aux += "\n..................................\n";

    return aux;
}

    public List<AvaliacaoFisica> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
        verificaDesconto();

    }

   public void verificaDesconto() {
    if (dataMatricula == null) {
        System.out.println("Data de matrícula não informada.");
        return;
    }

    if (plano.getValor() == 0.0) {
        System.out.println("Plano com valor zerado!");
        return;
    }

    Period periodo = Period.between(dataMatricula, LocalDate.now());
    int meses = periodo.getYears() * 12 + periodo.getMonths();

    valorMensalidade = plano.getValor();

    if (meses >= 3) {
        valorMensalidade -= (valorMensalidade * 0.1);
    }
}
}

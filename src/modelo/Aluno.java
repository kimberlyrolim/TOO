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
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{
    private String matricula;
    private LocalDate dataMatricula;
    private double valorMensalidade;
    Plano plano;
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
    
    public void adicionarAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
    }
    
    public String mostrarAvaliacoes(){
        String aux = "Histórico de Avaliações: \n";
        for(AvaliacaoFisica cadaAvaliacao: avaliacoes){
            aux += "->> "+ cadaAvaliacao+"\n";
        }
        return aux;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double verificaDesconto() {
    double valorBase = plano.getValor();
   
    int anos = LocalDate.now().getYear() - dataMatricula.getYear();
    int meses = LocalDate.now().getMonthValue() - dataMatricula.getMonthValue();
    int totalMeses = anos * 12 + meses;
    
    if (totalMeses >= 3) {
        return valorBase * 0.9; 
    } else {
        return valorBase;
    }
}
    @Override
    public String exibirDados() {
    String aux = "------ Dados do Aluno ------\n";
    aux += "Nome: " + getNome() + "\n";

    aux += "Matricula: " + matricula + "\n";
    
    if (plano != null) {
        aux += "Plano: " + plano.getNomePlano() + "\n";
        aux += "Descrição do Plano: " + plano.getDescricao() + "\n";
        aux += "Valor do Plano: " + plano.getValor() + "\n";
        aux += "Valor com Desconto: " + verificaDesconto() + "\n";
    } else {
        aux += "Plano: Não associado\n";
    } 
        return aux;
    }
    
    public void setDataMatricula(LocalDate dataMatricula) {
    this.dataMatricula = dataMatricula;
    }
    
    public void setPlano(Plano plano) {
    this.plano = plano;
    }
  
}

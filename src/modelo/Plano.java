/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author 20182PF.CC0076
 */
  public class Plano {
    private String nomePlano;
    private String descricao;
    private double valor = 150.0 ;

    public Plano(String nomePlano, String descricao, double valor) {
        this.nomePlano = nomePlano;
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   }


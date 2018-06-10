/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.model;

import br.com.finances.framework.dao.AbstractBean;

/**
 * Model for Renda entity
 *
 * @author joaovperin
 */
public class RendaBean extends AbstractBean<RendaBean> {

    private String nome;
    private float valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}

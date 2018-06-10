/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.model;

import br.com.finances.bean.AdBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Base Database Model
 *
 * @author joaovperin
 */
public class DataBaseModel {

    private List<RendaBean> renda;
    private List<ContaBean> conta;
    private List<AdBean> ad;

    /**
     * Default cosntructor to prevent NPEs
     */
    public DataBaseModel() {
        this.renda = new ArrayList<>();
        this.conta = new ArrayList<>();
        this.ad = new ArrayList<>();
    }

    public List<RendaBean> getRenda() {
        return renda;
    }

    public void setRenda(List<RendaBean> renda) {
        this.renda = renda;
    }

    public List<ContaBean> getConta() {
        return conta;
    }

    public void setConta(List<ContaBean> conta) {
        this.conta = conta;
    }

    public List<AdBean> getAd() {
        return ad;
    }

    public void setAd(List<AdBean> ad) {
        this.ad = ad;
    }

}

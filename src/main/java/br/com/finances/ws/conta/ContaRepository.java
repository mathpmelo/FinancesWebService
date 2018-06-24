/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.ws.conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * DAO for Conta entity
 * 
 * @author joaovperin
 */
public interface ContaRepository extends JpaRepository<Conta, String>, JpaSpecificationExecutor<Conta> {

}

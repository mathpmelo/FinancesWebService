/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.ws.renda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * DAO for Renda entity
 *
 * @author joaovperin
 */
public interface RendaRepository extends JpaRepository<Renda, String>, JpaSpecificationExecutor<Renda> {

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances;

import br.com.finances.services.HealthService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Configures the application with the supplied command line args
 *
 * @author joaovperin
 */
@Component
public class ApplicationConfig {

    @Autowired
    private HealthService health;

    /**
     * Starts the configurations
     *
     * @param args
     */
    public void config(String[] args) {
        System.out.println("*** Start of config.");
        health.setStartDate(new Date());
        health.setDatabaseConnection(true);
        System.out.println("*** End of config.");
    }

}

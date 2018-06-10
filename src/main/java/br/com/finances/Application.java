/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main class of the Application, responsible for config and start
 *
 * @author joaovperin
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class Application {

    /**
     * Runs the app
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args).
                getBean(ApplicationConfig.class).config(args);
    }

}

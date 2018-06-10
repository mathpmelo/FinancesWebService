/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances;

import br.com.finances.framework.dao.DatabaseConnection;
import br.com.finances.services.HealthService;
import java.io.File;
import java.io.IOException;
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
    private DatabaseConnection db;
    @Autowired
    private HealthService health;

    /**
     * Starts the configurations
     *
     * @param args
     */
    public void config(String[] args) {
        System.out.println("*** Start of config.");
        String dbName = "database.db";
        // If informed an argument, assume this as the database
        if (args != null && args.length == 1) {
            dbName = args[0];
        }
        // Creates the DB if not exists
        health.setDatabaseConnection(false);
        openDatabaseAndCreateIfNotExists(dbName);
        System.out.println("*** End of config.");
    }

    /**
     * Open the DB, creating that if not exists
     */
    private void openDatabaseAndCreateIfNotExists(String dbName) {
        // Gets the user home directory and creates app folder
        String home = System.getProperty("user.home");
        File dataDirectory = new File(home, ".finances");
        if (!dataDirectory.exists()) {
            dataDirectory.mkdir();
        }
        // Creates the file if not exists
        File f = new File(dataDirectory, dbName);
        if (f.exists()) {
            setDatabase(f.getAbsolutePath());
            return;
        }
        // If not exists, creates the file
        try {
            if (f.createNewFile()) {
                System.out.println("*** Created new DB file:" + f);
                setDatabase(f.getAbsolutePath());
            } else {
                throw new IOException();
            }
        } catch (IOException e) {
            System.out.println("*** Failed to create file:" + f);
            e.printStackTrace(System.out);
        }
    }

    /**
     * Sets the database to use
     *
     * @param dbFullPath
     */
    private void setDatabase(String dbFullPath) {
        System.out.println("*** Using database:".concat(dbFullPath));
        db.setDatabaseName(dbFullPath);
        health.setDatabaseConnection(true);
    }

}

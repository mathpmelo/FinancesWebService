/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.framework.dao;

import br.com.finances.model.DataBaseModel;
import br.com.finances.services.JsonService;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A single connection to the application database
 *
 * @author joaovperin
 */
@Component
public class DatabaseConnection implements Closeable {

    /** Database Name */
    private String databaseName;

    /** StringBuffer Initial Size */
    private static final int SB_SIZE = 8096;

    @Autowired
    private JsonService json;

    /** Database */
    private DataBaseModel database;

    /**
     * Returns the database model
     *
     * @return DataBaseModel
     * @throws DatabaseException Failed to open Database
     */
    public DataBaseModel get() throws DatabaseException {
        if (database == null) {
            System.out.println("*** Openning DATABAS!!!");
            open();
        }
        return database;
    }

    /**
     * Flush all the data to the database
     */
    public final void flush() throws DatabaseException {
        // Nothing to flush
        if (database == null) {
            System.out.println("*** Nothing to flush!");
            return;
        }
        // Renames the Database to a temporary file as a backup
        File newDatabase = new File(this.databaseName);
        File tmpFile = new File(this.databaseName + ".tmp");
        newDatabase.renameTo(tmpFile);
        // Tries to store the In-Memory Database with the old name
        String data = json.toPrettyJson(database, DataBaseModel.class);
        try (OutputStream ou = new FileOutputStream(newDatabase)) {
            // Create a new file and writes to it
            ou.write(data.getBytes());
            ou.flush();
            // If success, deletes the TMP file
            tmpFile.delete();
        } catch (IOException e) {
            throw new DatabaseException("*** Failed to flush data to database file " + this.databaseName, e);
        }
    }

    /**
     * Closes the database
     */
    @Override
    public final void close() {
        System.out.println("*** Closing database " + this.databaseName);
        try {
            flush();
        } catch (DatabaseException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Opens the database
     *
     * @throws DatabaseException Failed to open Database
     */
    private void open() throws DatabaseException {
        if (this.database != null) {
            throw new DatabaseException("Database Already Openned!");
        }
        if (this.databaseName == null || this.databaseName.trim().isEmpty()) {
            throw new DatabaseException("Invalid Database Name: " + this.databaseName);
        }
        // Opens the Database
        StringBuilder sb = new StringBuilder(SB_SIZE);
        try (BufferedReader bf = new BufferedReader(new FileReader(this.databaseName))) {
            String line;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new DatabaseException("Failed to Open Database!", e);
        }
        // NPE protection
        String db = sb.toString();
        if (db == null || db.trim().isEmpty()) {
            db = "{}";
        }
        // Casts the string read to the class
        this.database = json.castTo(db, DataBaseModel.class);
    }

    /**
     * Set the database name
     *
     * @param databaseName
     */
    public final void setDatabaseName(String databaseName) {
        if (database != null) {
            close();
        }
        this.databaseName = databaseName;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.framework.dao;

import br.com.finances.framework.dao.DatabaseConnection;
import br.com.finances.framework.dao.DatabaseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Flush data into the disk each 5 minutes
 *
 * @author joaovperin
 */
@Component
public class DatabaseFlushingTask {

    @Autowired
    private DatabaseConnection connection;

    /** Date format */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * Scheduled to flush data into disk each 5 minutes
     */
    @Scheduled(fixedRate = 5000 * 60)
    public void flushDataToDisk() {
        System.out.println("*** Flushing Data to Disk at [" + dateFormat.format(new Date()) + "]");
        try {
            connection.flush();
        } catch (DatabaseException e) {
            System.out.println("*** Failed to flush data to disk!!");
            e.printStackTrace(System.out);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.services;

import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * A Service to return the WS Health and some info
 *
 * @author joaovperin
 */
@Component
public class HealthService {

    private Date startDate;
    private String healthStatus;
    private boolean databaseConnection;

    public HealthService() {
        this.startDate = new Date();
        this.healthStatus = "OK!CUCUCUC";
        this.databaseConnection = false;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public boolean isDatabaseConnection() {
        return databaseConnection;
    }

    public void setDatabaseConnection(boolean databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

}

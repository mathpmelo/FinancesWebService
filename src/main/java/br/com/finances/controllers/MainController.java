/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.controllers;

import br.com.finances.anotattions.WebServiceAllowed;
import br.com.finances.framework.dao.DatabaseConnection;
import br.com.finances.framework.dao.DatabaseException;
import br.com.finances.services.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for the main activity
 *
 * @author joaovperin
 */
@Controller
public class MainController {

    @Autowired
    private HealthService health;
    @Autowired
    private DatabaseConnection conn;

    /**
     * Returns the WS current status
     *
     * @return JSON
     * @throws DatabaseException
     */
    @ResponseBody
    @WebServiceAllowed
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity status() throws DatabaseException {
        return new ResponseEntity<>(health, HttpStatus.OK);
    }

    /**
     * Flush Data into database
     *
     * @return JSON
     * @throws DatabaseException
     */
    @ResponseBody
    @WebServiceAllowed
    @RequestMapping(value = "/flush", method = RequestMethod.POST)
    public ResponseEntity flush() throws DatabaseException {
        conn.flush();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

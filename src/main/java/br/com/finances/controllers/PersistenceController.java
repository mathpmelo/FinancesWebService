/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.controllers;

import br.com.finances.anotattions.WebServiceAllowed;
import br.com.finances.framework.dao.DatabaseException;
import br.com.finances.framework.dao.PersistenceService;
import br.com.finances.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for Queries
 *
 * @author joaovperin
 */
@Controller
public class PersistenceController {

    @Autowired
    private PersistenceService persistence;
    @Autowired
    private RequestService request;

    /**
     * Insert a new register on the database
     *
     * @param entity
     * @return List
     * @throws DatabaseException
     */
    @ResponseBody
    @WebServiceAllowed
    @RequestMapping(value = "/{entity}", method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable String entity) throws DatabaseException {
        persistence.create(entity, request.getBody());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Update a register on the database, returning true if something got
     * updated
     *
     * @param entity
     * @return List
     * @throws DatabaseException
     */
    @ResponseBody
    @WebServiceAllowed
    @RequestMapping(value = "/{entity}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable String entity) throws DatabaseException {
        persistence.update(entity, request.getBody());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Delete a register from the database, returning true if found and deleted
     *
     * @param entity
     * @return List
     * @throws DatabaseException
     */
    @ResponseBody
    @WebServiceAllowed
    @RequestMapping(value = "/{entity}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String entity) throws DatabaseException {
        persistence.delete(entity, request.getBody());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

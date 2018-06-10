/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.controllers;

import br.com.finances.anotattions.WebServiceAllowed;
import br.com.finances.framework.dao.AbstractBean;
import br.com.finances.framework.dao.DatabaseException;
import br.com.finances.framework.dao.QueryService;
import java.util.List;
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
public class QueryController {

    @Autowired
    private QueryService query;

    /**
     * Query and return all the registers for one entity
     *
     * @param entity
     * @return List
     */
    @ResponseBody
    @WebServiceAllowed
    @RequestMapping(value = "/{entity}", method = RequestMethod.GET)
    public ResponseEntity read(@PathVariable String entity) {
        try {
            List<AbstractBean> list = query.read(entity, null);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

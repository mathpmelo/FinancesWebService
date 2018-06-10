/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.controllers;

import br.com.finances.anotattions.WebServiceAllowed;
import br.com.finances.bean.AdBean;
import br.com.finances.framework.dao.DatabaseException;
import br.com.finances.services.AdvertisementGeneratorService;
import br.com.finances.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for ADS :D
 *
 * @author joaovperin
 */
@Controller
public class AdController {

    @Autowired
    private AdvertisementGeneratorService adService;
    @Autowired
    private RequestService request;

    /**
     * Queries a random AD from the database
     *
     * @return ResponseEntity
     * @throws br.com.finances.framework.dao.DatabaseException
     */
    @ResponseBody
    @WebServiceAllowed
    @RequestMapping(value = "/ad", method = RequestMethod.POST)
    public ResponseEntity<AdBean> create() throws DatabaseException {
        adService.createNewAd(request.getBody());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Queries a random AD from the database
     *
     * @return ResponseEntity
     */
    @ResponseBody
    @WebServiceAllowed
    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public ResponseEntity<AdBean> read() {
        return new ResponseEntity<>(adService.randomAd(), HttpStatus.OK);
    }

}

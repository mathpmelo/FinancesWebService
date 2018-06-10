/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.framework.dao;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DAOFinder
 *
 * @author joaovperin
 */
@Component
public class DAOFinderService {

    /** Map with all the DAO implementations */
    @Autowired
    private Map<String, AbstractDAO> implementations;

    /**
     * Returns the DAO Instance
     *
     * @param entityName
     * @return AbstractDAO
     * @throws DatabaseException
     */
    public AbstractDAO get(String entityName) throws DatabaseException {
        String daoName = entityName.concat("DAO");
        if (!implementations.containsKey(daoName)) {
            throw new DatabaseException("Fail to find class " + daoName, new Exception());
        }
        return implementations.get(daoName);
    }

}

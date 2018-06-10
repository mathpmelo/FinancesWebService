/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.framework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Persistence Service
 *
 * @author joaovperin
 */
@Component
public class PersistenceService {

    @Autowired
    private DAOFinderService daoFinder;

    public void create(String entityName, String jsonObject) throws DatabaseException {
        AbstractDAO dao = daoFinder.get(entityName);
        dao.create(dao.bean(jsonObject));
    }

    public void update(String entityName, String jsonObject) throws DatabaseException {
        AbstractDAO dao = daoFinder.get(entityName);
        dao.update(dao.bean(jsonObject));
    }

    public void delete(String entityName, String jsonObject) throws DatabaseException {
        AbstractDAO dao = daoFinder.get(entityName);
        dao.delete(dao.bean(jsonObject));
    }

}

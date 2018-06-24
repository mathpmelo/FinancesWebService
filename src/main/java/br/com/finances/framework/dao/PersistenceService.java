/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.framework.dao;

import br.com.finances.services.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Persistence Service
 *
 * @author joaovperin
 */
@Component
public class PersistenceService {

    @Autowired
    private DAOFinderService daoFinder;
    @Autowired
    private JsonService jsons;

    public void create(String entityName, String jsonObject) throws DatabaseException {
        JpaRepository dao = daoFinder.get(entityName);
        dao.save(jsons.castTo(jsonObject, findClass(entityName, jsonObject)));
    }

    public void update(String entityName, String jsonObject) throws DatabaseException {
        JpaRepository dao = daoFinder.get(entityName);
        dao.save(jsons.castTo(jsonObject, findClass(entityName, jsonObject)));
    }

    public void delete(String entityName, String jsonObject) throws DatabaseException {
        JpaRepository dao = daoFinder.get(entityName);
        dao.delete(jsons.castTo(jsonObject, findClass(entityName, jsonObject)));
    }

    /**
     * Finds the properly bean class for the entity
     *
     * @param entityName
     * @param jsonObject
     * @return Class
     * @throws DatabaseException
     */
    private Class<?> findClass(String entityName, String jsonObject) throws DatabaseException {
        try {
            final String basePkg = "br.com.finances.ws.";
            return Class.forName(basePkg + entityName.toLowerCase() + "." + StringUtils.capitalize(entityName));
        } catch (ClassNotFoundException e) {
            throw new DatabaseException("Failed to instantiate bean class for entity '" + entityName + "'. Json: " + jsonObject, e);
        }
    }

}

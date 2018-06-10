/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.framework.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Query Service
 *
 * @author joaovperin
 */
@Component
public class QueryService {

    @Autowired
    private DAOFinderService daoFinder;

    public List<AbstractBean> read(String entityName, String jsonObject) throws DatabaseException {
        AbstractDAO dao = daoFinder.get(entityName);
        return dao.read();
    }

}

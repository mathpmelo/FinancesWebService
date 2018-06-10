/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.dao;

import br.com.finances.framework.dao.AbstractDAO;
import br.com.finances.framework.dao.DatabaseConnection;
import br.com.finances.framework.dao.DatabaseException;
import br.com.finances.model.RendaBean;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Data Access Object for Renda Entity
 *
 * @author joaovperin
 */
@Component
public class RendaDAO extends AbstractDAO<RendaBean> {

    @Autowired
    private DatabaseConnection conn;

    @Override
    public List<RendaBean> doRead() throws DatabaseException {
        return conn.get().getRenda();
    }

    @Override
    public void doInsert(RendaBean bean) throws DatabaseException {
        conn.get().getRenda().add(bean);
    }

    @Override
    public boolean doUpdate(RendaBean bean) throws DatabaseException {
        List<RendaBean> list = conn.get().getRenda();
        // Finds the element
        Optional<RendaBean> findFirst = list.stream().filter(b -> {
            return b.getNome().equals(bean.getNome());
        }).findFirst();
        // If finds
        if (findFirst.isPresent()) {
            list.set(list.indexOf(findFirst.get()), bean);
            return true;
        }
        return false;
    }

    @Override
    public boolean doDelete(RendaBean bean) throws DatabaseException {
        List<RendaBean> list = conn.get().getRenda();
        // Finds the element
        Optional<RendaBean> findFirst = list.stream().filter(b -> {
            return b.getNome().equals(bean.getNome());
        }).findFirst();
        // If finds
        if (findFirst.isPresent()) {
            list.remove(list.indexOf(findFirst.get()));
            return true;
        }
        return false;
    }

    @Override
    public RendaBean bean(String body) {
        return js.castTo(body, RendaBean.class);
    }

}

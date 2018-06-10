/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.dao;

import br.com.finances.framework.dao.AbstractDAO;
import br.com.finances.framework.dao.DatabaseConnection;
import br.com.finances.framework.dao.DatabaseException;
import br.com.finances.model.ContaBean;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Data Access Object for Conta Entity
 *
 * @author joaovperin
 */
@Component
public class ContaDAO extends AbstractDAO<ContaBean> {

    @Autowired
    private DatabaseConnection conn;

    @Override
    public List<ContaBean> doRead() throws DatabaseException {
        return conn.get().getConta();
    }

    @Override
    public void doInsert(ContaBean bean) throws DatabaseException {
        conn.get().getConta().add(bean);
    }

    @Override
    public boolean doUpdate(ContaBean bean) throws DatabaseException {
        List<ContaBean> list = conn.get().getConta();
        // Finds the element
        Optional<ContaBean> findFirst = list.stream().filter(b -> {
            return b.getProduto().equals(bean.getProduto());
        }).findFirst();
        // If finds
        if (findFirst.isPresent()) {
            list.set(list.indexOf(findFirst.get()), bean);
            return true;
        }
        return false;
    }

    @Override
    public boolean doDelete(ContaBean bean) throws DatabaseException {
        List<ContaBean> list = conn.get().getConta();
        // Finds the element
        Optional<ContaBean> findFirst = list.stream().filter(b -> {
            return b.getProduto().equals(bean.getProduto());
        }).findFirst();
        // If finds
        if (findFirst.isPresent()) {
            list.remove(list.indexOf(findFirst.get()));
            return true;
        }
        return false;
    }

    @Override
    public ContaBean bean(String body) {
        return js.castTo(body, ContaBean.class);
    }

}

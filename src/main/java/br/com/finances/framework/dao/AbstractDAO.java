/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.framework.dao;

import br.com.finances.services.JsonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * An abstract DAO Class
 *
 * @author joaovperin
 * @param <B>
 */
public abstract class AbstractDAO<B extends AbstractBean> {

    @Autowired
    protected JsonService js;

    protected abstract List<B> doRead() throws DatabaseException;

    protected abstract void doInsert(B bean) throws DatabaseException;

    protected abstract boolean doUpdate(B bean) throws DatabaseException;

    protected abstract boolean doDelete(B bean) throws DatabaseException;

    public abstract AbstractBean bean(String body);

    public final void create(B bean) throws DatabaseException {
        doInsert(bean);
    }

    public final List<B> read() throws DatabaseException {
        return doRead();
    }

    public final boolean update(B bean) throws DatabaseException {
        return doUpdate(bean);
    }

    public final boolean delete(B bean) throws DatabaseException {
        return doDelete(bean);
    }

}

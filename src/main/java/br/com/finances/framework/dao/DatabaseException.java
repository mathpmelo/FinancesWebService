/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.framework.dao;

/**
 * Default Exception for database problems
 *
 * @author joaovperin
 */
public class DatabaseException extends Exception {

    public DatabaseException(String string) {
        super(string);
    }

    public DatabaseException(Throwable thrwbl) {
        super(thrwbl);
    }

    public DatabaseException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}

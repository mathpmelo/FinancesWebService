/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A service to work with JSONs
 *
 * @author joaovperin
 */
@Service
public class JsonService {

    /** Object to deal with Json transformations */
    @Autowired
    private Gson g;
    /** Object to deal with Json transformations */
    private Gson prettyPrinter;

    /**
     * Returns the Gson instance
     *
     * @return Gson
     */
    private synchronized Gson getPrettyPrinter() {
        if (prettyPrinter == null) {
            prettyPrinter = new GsonBuilder().setPrettyPrinting().create();
        }
        return prettyPrinter;
    }

    /**
     * Converts an Object to a JSON String
     *
     * @param object
     * @param clazz
     * @return String
     */
    public String toPrettyJson(Object object, Class clazz) {
        return getPrettyPrinter().toJson(object, clazz);
    }

    /**
     * Converts an Object to a JSON String
     *
     * @param object
     * @return String
     */
    public String toJson(Object object) {
        return g.toJson(object);
    }

    /**
     * Converts an Object to a JSON String
     *
     * @param object
     * @param clazz
     * @return String
     */
    public String toJson(Object object, Class clazz) {
        return g.toJson(object, clazz);
    }

    /**
     * Converts the JSON String to a instance of any class
     *
     * @param <T>
     * @param jsonString
     * @param type
     * @return T
     */
    public <T> T castTo(String jsonString, Class<T> type) {
        return g.fromJson(jsonString, type);
    }

}

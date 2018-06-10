/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.services;

import org.springframework.stereotype.Service;

/**
 * A Simple String Service
 *
 * @author joaovperin
 */
@Service
public class StringService {

    /**
     * Capitalizes a String
     *
     * @param input
     * @return String
     */
    public String capitalize(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        int len = input.length();
        return input.substring(0, 1).toUpperCase().concat(input.substring(1, len));
    }

}

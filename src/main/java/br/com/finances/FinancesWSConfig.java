/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances;

import br.com.finances.interceptors.CORSHandlerMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configuration for the WebService
 *
 * @author joaovperin
 */
@Configuration
public class FinancesWSConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private CORSHandlerMapping corsInterceptor;

    /**
     * Add the interceptors to the registry
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor);
    }

}

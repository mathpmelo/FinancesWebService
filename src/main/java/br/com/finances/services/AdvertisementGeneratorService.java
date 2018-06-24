/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finances.services;

import br.com.finances.bean.AdBean;
import br.com.finances.framework.dao.DatabaseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Generate ADs :D
 *
 * @author joaovperin
 */
@Service
public class AdvertisementGeneratorService {

    @Autowired
    protected JsonService js;

    /** List of ADS */
    private List<String> adsList;
    /** Random Number Generator */
    private final Random r;

    /**
     * Default constructor
     */
    public AdvertisementGeneratorService() {
        this.r = new Random(System.currentTimeMillis());
    }

    /**
     * Returns a new Random AD as a bean
     *
     * @return AdBean
     */
    public AdBean randomAd() {
        AdBean ad = new AdBean();
        ad.setMessage(randomAdString());
        return ad;
    }

    /**
     * Creates a new AD and inserts on the DB
     *
     * @param json
     * @throws br.com.finances.framework.dao.DatabaseException
     */
    public void createNewAd(String json) throws DatabaseException {
        if (adsList != null) {
            adsList.add(json);
        }
    }

    /**
     * Generates (query) a randomAd
     *
     * @return String
     */
    private String randomAdString() {
        // If the list is empty
        if (adsList == null) {
            this.adsList = new ArrayList<>();
            loadAds(adsList);
        }
        // Returns a random AD from the list
        int idx = randInt(adsList.size());
        if (adsList.isEmpty() || adsList.size() < idx) {
            return "No AD found. Try again later ;)";
        }
        return adsList.get(idx);
    }

    /**
     * Returns a random int until (excludding) the value
     *
     * @param end
     * @return int
     */
    private int randInt(int end) {
        int n = r.nextInt();
        int ri = (n > 0 ? n : -n);
        return end == 0 ? end : ri % end;
    }

    /**
     * Loads some ADS in the list
     *
     * @param list
     */
    private void loadAds(List<String> list) {
        list.add("Acesse agora o site MercadoLivre.com.br e confira nossas ofertas imperdíveis!!");
        list.add("Computador barato é só na Kabum!");
        list.add("Não basta ser bom. Tem que ser LEBOM!!");
        list.add("É só amanhã nas casas bahia!!");
        list.add("Hotel?? Trivago :D");
    }

}

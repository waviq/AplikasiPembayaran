package com.mastahcode.waviq.pembayaran.restclient;

import com.mastahcode.waviq.pembayaran.exceptions.GagalLoginException;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by waviq on 30/08/2016.
 * <p/>
 * Servie untuk konek ke web service
 */
public class PembayaranClient {

    private static final String URL_SERVER = "https://pembayarans.herokuapp.com/";

    private RestTemplate restTemplate = new RestTemplate();

    public void login(String username, String password) throws GagalLoginException {

        Map<String, String> loginData = new HashMap<>();
        loginData.put("username", username);
        loginData.put("password", password);

        Map<String, Object> hasil = restTemplate
                .postForObject(URL_SERVER + "/api/login", loginData, Map.class, new Object[]{}
                );

        //cek hasil
        if (hasil == null) {
            throw new GagalLoginException("Response invalid");
        }
        if (!(Boolean) hasil.get("sukses")) {
            throw new GagalLoginException("username / Password salah");
        }

    }
}

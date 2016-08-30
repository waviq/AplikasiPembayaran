package com.mastahcode.waviq.pembayaran.exceptions;

/**
 * Created by waviq on 30/08/2016.
 * Nangkep error ketika gagal login
 */
public class GagalLoginException extends Exception {

    //ovveride exception yang pakai message (alt+insert)
    public GagalLoginException(String message) throws GagalLoginException {
        super(message);
    }
}

package com.qualitas.portal.fraudes.account.application.service;

public interface CodigoEmailService {


    void generarCodigoParaRestablecimiento(String email);
    boolean verificarCodigoRestablecimiento(String email, String codigoIngresado);
    String generarCodigoRestablecimiento();

    void eliminarCodigoRestablecimiento(String email);
}

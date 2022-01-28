package com.redhat.Services;


import java.util.logging.Level;

import com.example.registro.CrearRegistroPortType;
import com.example.registro.types.RegistroType;
import com.sun.istack.logging.Logger;

import org.springframework.stereotype.Service;
@Service
public class TestService implements CrearRegistroPortType {

  @Override
  public RegistroType crearRegistro(RegistroType request) {
    Logger.getLogger(TestService.class).log(Level.INFO, "Value " + request.getValue());
    RegistroType response = new RegistroType();
    response.setValue("hello " + request.getValue());
    return response;
  }
}

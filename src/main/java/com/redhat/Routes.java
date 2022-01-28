package com.redhat;


import com.example.registro.CrearRegistro;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Routes extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    String cxfEndpoint = "cxf:/test-soap?serviceClass=" + CrearRegistro.class.getName()
        + "&wsdlURL=classpath:wsdl/file.wsdl" + "&loggingFeatureEnabled=true" + "&dataFormat=RAW";
    from(cxfEndpoint)
        .transform(simple("${body[0]}"));
  }
}
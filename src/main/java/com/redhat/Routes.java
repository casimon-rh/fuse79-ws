package com.redhat;

import com.example.registro.types.RegistroType;
import com.redhat.Services.TestService;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JacksonXMLDataFormat;
import org.springframework.stereotype.Component;
@Component
public class Routes extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    String cxfEndpoint = "cxf:/test-soap?serviceClass=" + TestService.class.getName()
        + "&wsdlURL=classpath:wsdl/file.wsdl" + "&loggingFeatureEnabled=true";
    
    JacksonXMLDataFormat df = new JacksonXMLDataFormat();
    df.setPrettyPrint(true);
    df.setUnmarshalType(RegistroType.class);

    from(cxfEndpoint)
        .transform(simple("${body[0]}"))
        .marshal(df)
        .to("log:DEBUG?showBody=true")
        .unmarshal(df);
  }
}
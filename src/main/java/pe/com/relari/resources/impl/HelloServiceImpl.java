package pe.com.relari.resources.impl;

import jakarta.jws.WebService;
import jakarta.xml.ws.Holder;
import pe.com.relari.resources.HelloService;

@WebService(
        serviceName = "HelloService",
        endpointInterface = "pe.com.relari.resources.HelloService",
        targetNamespace = "http://relari")
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(Holder<String> txtFruitName) {
        return "Hello " + (txtFruitName.value == null ? "Default" : txtFruitName.value) + "!";
    }

}

package pe.com.relari.resources;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.Holder;

/**
 * The simplest Hello service.
 */
@WebService(
        targetNamespace = "http://relari",
        name = "HelloService"//,
//        serviceName = "HelloService"
)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface HelloService {

    @WebMethod(operationName = "hello", action = "hello")
    String hello(
            @WebParam(
                    partName = "txtFruitName",
                    mode = WebParam.Mode.IN,
                    name = "txtFruitName",
                    targetNamespace = "http://relari"
            )
            Holder<String> txtFruitName
    );

}
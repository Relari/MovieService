package pe.com.relari.resources;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import pe.com.relari.model.Fruit;

import java.util.Set;

@WebService(name = "FruitResource", serviceName = "FruitResource")
public interface FruitResource {

    @WebMethod(operationName = "add", action = "add")
    Fruit add(Fruit fruit);

    @WebMethod(operationName = "list", action = "list")
    Set<Fruit> list();

    @WebMethod(operationName = "get", action = "get")
    Fruit get(String name);

}

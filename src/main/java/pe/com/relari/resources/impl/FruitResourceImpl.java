package pe.com.relari.resources.impl;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.jboss.logging.Logger;
import pe.com.relari.model.Fruit;
import pe.com.relari.resources.FruitResource;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebService(serviceName = "FruitResource")
public class FruitResourceImpl implements FruitResource {

    private static final Logger log = Logger.getLogger(FruitResourceImpl.class);


    private static final Set<Fruit> fruits = Collections.synchronizedSet(new HashSet<>());

    public FruitResourceImpl() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @WebMethod
    @Override
    public Fruit add(Fruit fruit) {
        log.debug("Begin");

        log.tracef("Request -> ", fruit);
        fruits.add(fruit);

        log.debug("End");
        return fruit;
    }

    @WebMethod
    @Override
    public Set<Fruit> list() {
        return fruits;
    }

    @WebMethod
    @Override
    public Fruit get(String name) {
        return fruits.stream()
                .filter(fruit -> fruit.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Fruit not found."));
    }
}

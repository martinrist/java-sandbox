package com.martinrist.springInAction.spittr.ws;

import com.martinrist.springInAction.spittr.domain.Spitter;
import com.martinrist.springInAction.spittr.domain.Spittle;
import com.martinrist.springInAction.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint {

    @Autowired
    SpitterService spitterService;

    @WebMethod
    public List<Spittle> getRecentSpittles(int count) {
        return spitterService.getRecentSpittles(count);
    }

    @WebMethod
    public void addSpittle(Spittle spittle) {
        spitterService.saveSpittle(spittle);
    }

    @WebMethod
    public void addSpitter(Spitter spitter) {
        spitterService.saveSpitter(spitter);
    }

    @WebMethod
    public Spitter getSpitter(String username) {
        return spitterService.getSpitter(username);
    }

    @WebMethod
    public Spittle getSpittle(long id) {
        return spitterService.getSpittleById(id);
    }

    @WebMethod
    public void deleteSpittle(long id) {
        spitterService.deleteSpittle(id);
    }
}


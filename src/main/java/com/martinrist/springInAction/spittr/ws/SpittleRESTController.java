package com.martinrist.springInAction.spittr.ws;

import com.martinrist.springInAction.spittr.domain.Spittle;
import com.martinrist.springInAction.spittr.exception.SpittleNotFoundException;
import com.martinrist.springInAction.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/spittles")
public class SpittleRESTController {

    private SpitterService service;

    @Autowired
    public SpittleRESTController(SpitterService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value="count", defaultValue = "20") int count) {
        return service.getRecentSpittles(count);
    }

    @RequestMapping(path = "/{spittleId}", method = RequestMethod.GET)
    public Spittle spittle(@PathVariable("spittleId") long spittleId) {
        Spittle spittle = service.getSpittleById(spittleId);
        if (spittle == null) throw new SpittleNotFoundException(spittleId);
        return spittle;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Spittle> saveSpittle(@RequestBody Spittle spittle,
                                               UriComponentsBuilder ucb) {

        Spittle savedSpittle = service.saveSpittle(spittle);

        HttpHeaders headers = new HttpHeaders();

        URI locationUri = ucb.path("/api/spittles/")
                             .path(String.valueOf(savedSpittle.getId()))
                             .build().toUri();

        headers.setLocation(locationUri);

        return new ResponseEntity<>(savedSpittle, headers, HttpStatus.CREATED);
    }

    @ExceptionHandler(SpittleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error spittleNotFound(SpittleNotFoundException snfe) {
        long spittleId = snfe.getSpittleId();
        Error e = new Error(4, "Spittle [" + spittleId + "] not found");
        return e;
    }
}
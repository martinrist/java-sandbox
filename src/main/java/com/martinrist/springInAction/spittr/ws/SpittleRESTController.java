package com.martinrist.springInAction.spittr.ws;

import com.martinrist.springInAction.spittr.domain.Spittle;
import com.martinrist.springInAction.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/spittles")
public class SpittleRESTController {

    private SpitterService service;

    @Autowired
    public SpittleRESTController(SpitterService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Spittle> spittles(@RequestParam(value="count", defaultValue = "20") int count) {
        return service.getRecentSpittles(count);
    }

    @RequestMapping(path = "/{spittleId}", method = RequestMethod.GET)
    public @ResponseBody Spittle spittle(@PathVariable("spittleId") long spittleId, Model model) {
        return service.getSpittleById(spittleId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody Spittle saveSpittle(@RequestBody Spittle spittle) {
        return service.saveSpittle(spittle);
    }
}
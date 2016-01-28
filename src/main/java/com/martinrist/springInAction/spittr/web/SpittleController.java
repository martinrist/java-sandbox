package com.martinrist.springInAction.spittr.web;

import com.martinrist.springInAction.spittr.domain.Spittle;
import com.martinrist.springInAction.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpitterService service;

    @Autowired
    public SpittleController(SpitterService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value="count", defaultValue = "20") int count) {
        return service.getRecentSpittles(count);
    }

    @RequestMapping(path = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {

        model.addAttribute(service.getSpittleById(spittleId));
        return "spittle";
    }
}

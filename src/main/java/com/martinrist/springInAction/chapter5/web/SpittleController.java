package com.martinrist.springInAction.chapter5.web;

import com.martinrist.springInAction.chapter5.data.SpittleRepository;
import com.martinrist.springInAction.chapter5.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    /**
     * The maximum allowable value of the 'max' parameter.  Ideally we'd use
     * something like Long.toString(Long.MAX_VALUE) here, but this can't be
     * assigned to @RequestParam's defaultValue attribute, because it isn't
     * a compile-time constant.
     *
     * This has package level access because it needs to be accessible from
     * the unit tests, but not outside the package.
     */
    static final String MAX_ID = "9999999999999999";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value="max", defaultValue = MAX_ID) long max,
                                  @RequestParam(value="count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

}

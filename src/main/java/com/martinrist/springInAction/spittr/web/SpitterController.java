package com.martinrist.springInAction.spittr.web;

import com.martinrist.springInAction.spittr.data.SpitterRepository;
import com.martinrist.springInAction.spittr.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Controller for registering new users (Spitters) to the application.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    public static final String DEFAULT_UPLOAD_DIR = "/tmp/spittr/profiles";

    private SpitterRepository spitterRepository;

    @Autowired(required = false)
    private String imageUploadDir = DEFAULT_UPLOAD_DIR;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value="/register", method=POST)
    public String processRegistration(@RequestPart MultipartFile profilePicture, @Valid Spitter spitter, Errors errors) {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        spitterRepository.save(spitter);

        try {
            profilePicture.transferTo(new File(imageUploadDir + "/" + profilePicture.getOriginalFilename()));
        } catch (IOException e) {
            // For now, we'll just ignore the picture upload if there's a problem
            e.printStackTrace();
        }

        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value="/{username}", method=GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUserName(username);
        model.addAttribute(spitter);
        return "profile";
    }

}

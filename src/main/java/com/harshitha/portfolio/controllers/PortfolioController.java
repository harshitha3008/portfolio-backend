package com.harshitha.portfolio.controllers;

import com.harshitha.portfolio.utils.JsonReader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PortfolioController {

    @GetMapping("/api/home")
    public Map<String, Object> home() throws IOException {
        return JsonReader.readJsonAsMap("home.json");
    }

    @GetMapping("/api/about")
    public Map<String, Object> about() throws IOException {
        return JsonReader.readJsonAsMap("about.json");
    }

    @GetMapping("/api/experience")
    public List<Object> experience() throws IOException {
        return JsonReader.readJsonAsList("experience.json");
    }

    @GetMapping("/api/skills")
    public List<Object> skills() throws IOException {
        return JsonReader.readJsonAsList("skills.json");
    }

    @GetMapping("/api/projects")
    public List<Object> projects() throws IOException {
        return JsonReader.readJsonAsList("projects.json");
    }

    @GetMapping("/api/education")
    public List<Object> education() throws IOException {
        return JsonReader.readJsonAsList("education.json");
    }

    @GetMapping("/api/certifications")
    public List<Object> certifications() throws IOException {
        return JsonReader.readJsonAsList("certifications.json");
    }

    @GetMapping("/api/leadership")
    public List<Object> leadership() throws IOException {
        return JsonReader.readJsonAsList("leadership.json");
    }

    @GetMapping("/api/contact")
    public Map<String, Object> contact() throws IOException {
        return JsonReader.readJsonAsMap("contact.json");
    }
}

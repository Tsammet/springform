package com.formulario.formulario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.formulario.formulario.models.Person;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class FormController {

    private List<Person> formPersonList = new ArrayList<>();

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("formPersonList", formPersonList);
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("edad") int edad, Model model ){
        Person persona = new Person(nombre, apellido, edad);
        formPersonList.add(persona);
        model.addAttribute("formPersonList", formPersonList);
        return "form";

        }
    
    }
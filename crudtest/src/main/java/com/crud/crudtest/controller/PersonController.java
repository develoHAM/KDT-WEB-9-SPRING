package com.crud.crudtest.controller;


import com.crud.crudtest.dto.PersonDTO;
import com.crud.crudtest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


    //회원가입
    @GetMapping("/register")
    public  String getRegister() {
        return "register";
    }
    @PostMapping("/register")
    @ResponseBody
    public boolean postRegister(@RequestBody PersonDTO personDTO) {

        personService.insertPerson(personDTO);
        return  true;
    }

    //로그인
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin( @RequestBody PersonDTO personDTO) {
       return personService.getPerson(personDTO);

    }

}

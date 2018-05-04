package com.soschat.web.controllers;

import com.soschat.object.form.SosForm;
import com.soschat.object.repository.SosFormRepository;
import com.soschat.web.service.SpringObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {

    @Autowired
    private SosFormRepository sosFormRepository;

    @Autowired
    private SpringObjectService springObjectService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "HelloWorld!";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public SosForm createForm(@RequestBody SosForm sosForm) {
        System.out.println("SosForm - " + sosForm);
        sosFormRepository.save(sosForm);
        System.out.println("SosForm Id = " + sosForm.getId());
        return sosForm;
    }

    @RequestMapping(value = "/form/cache", method = RequestMethod.POST)
    public SosForm createFormCache(@RequestBody SosForm sosForm) {
        System.out.println("SosForm - " + sosForm);
        System.out.println("SosForm Id = " + sosForm.getId());
        springObjectService.saveSosFormCache(sosForm);
        return sosForm;
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public SosForm getForm(@PathVariable(value = "id") long id) {
        return sosFormRepository.findById(id).get();
    }


    @RequestMapping(value = "/form/container/{containerId}", method = RequestMethod.GET)
    public List<SosForm> getFormInContainer(@PathVariable(value = "containerId") long containerId) {
        return sosFormRepository.findByContainerId(containerId);
    }

    @RequestMapping(value = "/form/cache/{id}", method = RequestMethod.GET)
    public SosForm getSosFormFromCache(@PathVariable(value = "id") long id) {
        return springObjectService.getFormFromCache(id);
    }

}

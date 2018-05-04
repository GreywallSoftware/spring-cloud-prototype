package com.soschat.web.service;

import com.soschat.object.form.SosForm;
import com.soschat.object.repository.SosFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SpringObjectService {

    @Autowired
    private SosFormRepository sosFormRepository;

    @Cacheable(value = "SosForm")
    public SosForm getFormFromCache(long id) {
        return sosFormRepository.findById(id).get();
    }


    @CachePut(value = "SosForm", key = "#result.id")
    public SosForm saveSosFormCache(SosForm sosForm) {
        sosFormRepository.save(sosForm);
        return sosForm;
    }

}

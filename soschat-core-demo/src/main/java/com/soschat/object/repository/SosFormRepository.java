package com.soschat.object.repository;

import com.soschat.object.form.SosForm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SosFormRepository  extends CrudRepository<SosForm, Long> {
    List<SosForm> findByContainerId(long containerId);
}

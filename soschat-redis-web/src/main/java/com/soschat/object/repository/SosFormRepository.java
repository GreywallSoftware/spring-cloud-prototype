package com.soschat.object.repository;

import com.soschat.object.form.SosForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SosFormRepository  extends CrudRepository<SosForm, Long> {
    List<SosForm> findByContainerId(long containerId);
}

package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateRateDto;
import com.umssonline.social.common.dto.UpdateRateDto;
import com.umssonline.social.models.Rate;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface RatesRestController {

    ResponseEntity<Rate> findById(final Long id) throws Exception;

    ResponseEntity<Collection<Rate>> findAll() throws Exception;

    ResponseEntity<Collection<Rate>> findByProperty(final String property, final Object value);

    ResponseEntity<Rate> create(final CreateRateDto messageDto) throws Exception;

    ResponseEntity<Rate> update(final UpdateRateDto messageDto) throws Exception;

    ResponseEntity<Void> deleteById(final Long id);
}

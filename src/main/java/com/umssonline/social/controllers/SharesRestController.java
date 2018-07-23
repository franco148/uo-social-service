package com.umssonline.social.controllers;

import com.umssonline.social.models.Share;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface SharesRestController {

    ResponseEntity<Share> findById(final Long id) throws Exception;

    ResponseEntity<Collection<Share>> findAll() throws Exception;

    ResponseEntity<Collection<Share>> findByProperty(final String property, final Object value);

    ResponseEntity<Share> create(final Object messageDto) throws Exception;

    ResponseEntity<Share> update(final Object messageDto) throws Exception;

    ResponseEntity<Void> deleteById(final Long id);
}

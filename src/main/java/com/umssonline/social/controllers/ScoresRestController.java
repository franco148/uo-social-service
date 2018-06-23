package com.umssonline.social.controllers;

import com.umssonline.social.models.Score;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ScoresRestController {

    ResponseEntity<Score> findById(final Long id) throws Exception;

    ResponseEntity<Collection<Score>> findAll() throws Exception;

    ResponseEntity<Collection<Score>> findByProperty(final String propName, final  String propValue);

    ResponseEntity<Score> create(final Object scoreDto) throws Exception;

    ResponseEntity<Score> update(final Object scoreDto);

    ResponseEntity<Void> deleteById(final Long id);
}

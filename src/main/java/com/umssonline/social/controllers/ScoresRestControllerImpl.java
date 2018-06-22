package com.umssonline.social.controllers;

import com.umssonline.social.models.Score;
import com.umssonline.social.services.SocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/scores")
public class ScoresRestControllerImpl implements ScoresRestController {

    //region Properties
    @Autowired
    private SocialService<Score> scoreService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region ScoresRestController Members
    @Override
    public ResponseEntity<Score> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Score>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Score>> findByProperty(String propName, String propValue) {
        return null;
    }

    @Override
    public ResponseEntity<Score> create(Object scoreDto) {
        return null;
    }

    @Override
    public ResponseEntity<Score> update(Object scoreDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return null;
    }
    //endregion
}

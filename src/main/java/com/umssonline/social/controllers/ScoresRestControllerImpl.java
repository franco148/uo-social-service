package com.umssonline.social.controllers;

import com.umssonline.social.models.entity.Score;
import com.umssonline.social.services.CrudSocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/scores")
public class ScoresRestControllerImpl implements ScoresRestController {

    //region Properties
    @Autowired
    private CrudSocialService<Score> scoreService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region ScoresRestController Members
    @Override
    @GetMapping("/{score_id}")
    public ResponseEntity<Score> findById(@PathVariable("score_id") final Long id) throws Exception {

        try {
            Score scoreResponse = scoreService.findById(id);
            return new ResponseEntity<>(scoreResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting a score: " + ex.getMessage());
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Score>> findAll() throws Exception {

        try {
            Collection<Score> scoresResponse = scoreService.findAll();

            if (scoresResponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(scoresResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting scores: " + ex.getMessage());
        }
    }

    @Override
    @GetMapping("/property")
    public ResponseEntity<Collection<Score>> findByProperty(String propName, String propValue) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<Score> create(@RequestBody final Object scoreDto) throws Exception {

        Score converted = modelMapper.map(scoreDto, Score.class);
        try {
            Score savedScore = scoreService.save(converted);
            return new ResponseEntity<>(savedScore, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Save score has failed. The operation has been terminated: " + ex.getMessage());
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<Score> update(@RequestBody final Object scoreDto) {
        return null;
    }

    @Override
    @DeleteMapping("/{score_id}")
    public ResponseEntity<Void> deleteById(@PathVariable("score_id") final Long id) {
        scoreService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //endregion
}

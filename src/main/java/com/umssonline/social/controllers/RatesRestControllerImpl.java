package com.umssonline.social.controllers;

import com.umssonline.social.models.dto.CreateRateDto;
import com.umssonline.social.models.dto.UpdateRateDto;
import com.umssonline.social.models.entity.Rate;
import com.umssonline.social.services.CrudSocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rates")
public class RatesRestControllerImpl implements RatesRestController {

    //region Properties
    @Autowired
    private CrudSocialService<Rate> rateService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region RatesRestController Members
    @Override
    @GetMapping("/{rate_id}")
    public ResponseEntity<Rate> findById(@PathVariable("rate_id") final Long id) throws Exception {

        try {
            Rate rateResponse = rateService.findById(id);
            return new ResponseEntity<>(rateResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting a rate: " + ex.getMessage());
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Rate>> findAll() throws Exception {

        try {
            Collection<Rate> ratesResponse = rateService.findAll();

            if (ratesResponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ratesResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting rates: " + ex.getMessage());
        }
    }

    @Override
    @GetMapping("/property")
    public ResponseEntity<Collection<Rate>> findByProperty(@RequestParam("prop") final String property,
                                                           @RequestParam("val") final Object value) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<Rate> create(@RequestBody final CreateRateDto rateDto) throws Exception {

        Rate converted = modelMapper.map(rateDto, Rate.class);
        try {
            Rate savedRate = rateService.save(converted);
            return new ResponseEntity<>(savedRate, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Save rate has failed. The operation has been terminated: " + ex.getMessage());
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<Rate> update(@RequestBody final UpdateRateDto rateDto) throws Exception {
        return null;
    }

    @Override
    @DeleteMapping("/{rate_id}")
    public ResponseEntity<Void> deleteById(@PathVariable("rate_id") final Long id) {
        rateService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //endregion

}

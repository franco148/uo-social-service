package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateRateDto;
import com.umssonline.social.common.dto.UpdateRateDto;
import com.umssonline.social.models.Rate;
import com.umssonline.social.services.SocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rates")
public class RatesRestControllerImpl implements RatesRestController {

    //region Properties
    @Autowired
    private SocialService<Rate> rateService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region RatesRestController Members
    @Override
    @GetMapping("/{rate_id}")
    public ResponseEntity<Rate> findById(@PathVariable("rate_id") final Long id) throws Exception {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Rate>> findAll() throws Exception {
        return null;
    }

    @Override
    @GetMapping("/property")
    public ResponseEntity<Collection<Rate>> findByProperty(@RequestParam("prop") final String property,
                                                           @RequestParam("val") final Object value) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<Rate> create(@RequestBody final CreateRateDto messageDto) throws Exception {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<Rate> update(@RequestBody final UpdateRateDto messageDto) throws Exception {
        return null;
    }

    @Override
    @DeleteMapping("/{rate_id}")
    public ResponseEntity<Void> deleteById(@PathVariable("rate_id") final Long id) {
        return null;
    }
    //endregion

}

package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateRateDto;
import com.umssonline.social.common.dto.UpdateRateDto;
import com.umssonline.social.models.Rate;
import com.umssonline.social.services.SocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Rate> findById(Long id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Rate>> findAll() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Rate>> findByProperty(String property, Object value) {
        return null;
    }

    @Override
    public ResponseEntity<Rate> create(CreateRateDto messageDto) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Rate> update(UpdateRateDto messageDto) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return null;
    }
    //endregion

}

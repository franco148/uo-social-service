package com.umssonline.social.controllers;

import com.umssonline.social.models.Share;
import com.umssonline.social.services.SocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/shares")
public class SharesRestControllerImpl implements SharesRestController {

    //region Properties
    @Autowired
    private SocialService<Share> shareService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region SharesRestController Members
    @Override
    public ResponseEntity<Share> findById(Long id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Share>> findAll() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Share>> findByProperty(String property, Object value) {
        return null;
    }

    @Override
    public ResponseEntity<Share> create(Object messageDto) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Share> update(Object messageDto) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return null;
    }
    //endregion
}

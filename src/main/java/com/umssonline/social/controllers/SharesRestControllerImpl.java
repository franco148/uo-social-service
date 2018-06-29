package com.umssonline.social.controllers;

import com.umssonline.social.models.Share;
import com.umssonline.social.services.SocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{share_id}")
    public ResponseEntity<Share> findById(@PathVariable("share_id") final Long id) throws Exception {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Share>> findAll() throws Exception {
        return null;
    }

    @Override
    @GetMapping("/property")
    public ResponseEntity<Collection<Share>> findByProperty(@RequestParam("prop") final String property,
                                                            @RequestParam("val") final Object value) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<Share> create(@RequestBody final Object messageDto) throws Exception {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<Share> update(@RequestBody final Object messageDto) throws Exception {
        return null;
    }

    @Override
    @DeleteMapping("/{share_id}")
    public ResponseEntity<Void> deleteById(@PathVariable("share_id") final Long id) {
        return null;
    }
    //endregion
}

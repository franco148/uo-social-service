package com.umssonline.social.services.impl;

import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.repositories.api.ExtendedParticipantDao;
import com.umssonline.social.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

@Service("participantService")
public class ParticipantServiceImpl implements ParticipantService {

    //region Properties
    @Autowired
    private ExtendedParticipantDao participantDao;
    //endregion

    //region SocialService Members
    @Transactional(readOnly = true)
    @Override
    public Participant findById(Serializable id) {
        return participantDao.findById(id);
    }

    @Override
    public Collection<Participant> findByProperty(String propertyName) {
        return null;
    }

    @Override
    public Collection<Participant> findAll() {
        return participantDao.findAll();
    }

    @Override
    public Participant save(Participant participant) {
        return participantDao.create(participant);
    }

    @Override
    public Participant update(Participant participant) {
        return participantDao.update(participant);
    }

    @Override
    public void delete(Participant participant) {
        participantDao.delete(participant);
    }

    @Override
    public void deleteById(Serializable id) {
        participantDao.deleteById(id);
    }
    //endregion
}

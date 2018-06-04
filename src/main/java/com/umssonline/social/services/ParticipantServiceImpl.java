package com.umssonline.social.services;

import com.umssonline.social.models.Participant;
import com.umssonline.social.repositories.api.ExtendedParticipantDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
public class ParticipantServiceImpl implements SocialService<Participant> {

    //region Properties
    @Resource
    private ExtendedParticipantDao participantDao;
    //endregion

    //region SocialService Members
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
    public Participant save(Participant participant) throws Exception {
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

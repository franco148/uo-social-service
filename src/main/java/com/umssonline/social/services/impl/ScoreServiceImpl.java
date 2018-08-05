package com.umssonline.social.services.impl;

import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.models.entity.Resource;
import com.umssonline.social.models.entity.Score;
import com.umssonline.social.repositories.api.ExtendedScoreDao;
import com.umssonline.social.services.ParticipantService;
import com.umssonline.social.services.ResourceService;
import com.umssonline.social.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Collection;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

    //region Properties
    @Autowired
    private ExtendedScoreDao scoreDao;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ParticipantService participantService;
    //endregion

    //region CrudSocialService Members
    @Override
    public Score findById(Serializable id) {
        return scoreDao.findById(id);
    }

    @Override
    public Collection<Score> findByProperty(String propertyName) {
        return null;
    }

    @Override
    public Collection<Score> findAll() {
        return scoreDao.findAll();
    }

    @Override
    public Score save(Score score) {

        if (score.getRatedResource() == null || score.getCreatedBy() == null) {
            throw new EntityNotFoundException("Neither Resource nor CreatedBy properties can be null.");
        }

        Resource resourceFromDb = resourceService.findById(score.getRatedResource().getId());
        if (resourceFromDb == null) {
            throw new EntityNotFoundException("Score can not be created, it does not have a related Resource");
        }

        Participant participantFromDb = participantService.findById(score.getCreatedBy().getId());
        if (participantFromDb == null) {
            throw new EntityNotFoundException("The owner who is creating the comment does not exists.");
        }

        score.setRatedResource(resourceFromDb);
        score.setCreatedBy(participantFromDb);

        return scoreDao.create(score);
    }

    @Override
    public Score update(Score score) {
        return null;
    }

    @Override
    public void delete(Score score) {
        scoreDao.delete(score);
    }

    @Override
    public void deleteById(Serializable id) {
        scoreDao.deleteById(id);
    }
    //endregion
}

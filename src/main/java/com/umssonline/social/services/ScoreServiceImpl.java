package com.umssonline.social.services;

import com.umssonline.social.models.Participant;
import com.umssonline.social.models.Resource;
import com.umssonline.social.models.Score;
import com.umssonline.social.repositories.api.ExtendedScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

@Service("scoreService")
public class ScoreServiceImpl implements SocialService<Score> {

    //region Properties
    @Autowired
    private ExtendedScoreDao scoreDao;

    @Autowired
    private SocialService<Resource> resourceService;

    @Autowired
    private SocialService<Participant> participantService;
    //endregion

    //region SocialService Members
    @Override
    public Score findById(Serializable id) throws Exception {
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
    public Score save(Score score) throws Exception {

        if (score.getRatedResource() == null || score.getCreatedBy() == null) {
            throw new Exception("Neither Resource nor CreatedBy properties can be null.");
        }

        Resource resourceFromDb = resourceService.findById(score.getRatedResource().getId());
        if (resourceFromDb == null) {
            throw new Exception("Score can not be created, it does not have a related Resource");
        }

        Participant participantFromDb = participantService.findById(score.getCreatedBy().getId());
        if (participantFromDb == null) {
            throw new Exception("The owner who is creating the comment does not exists.");
        }

        score.setRatedResource(resourceFromDb);
        score.setCreatedBy(participantFromDb);

        return scoreDao.create(score);
    }

    @Override
    public Score update(Score score) throws Exception {
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

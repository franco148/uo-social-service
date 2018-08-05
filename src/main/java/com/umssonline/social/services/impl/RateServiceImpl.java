package com.umssonline.social.services.impl;

import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.models.entity.Rate;
import com.umssonline.social.models.entity.Score;
import com.umssonline.social.repositories.api.ExtendedRateDao;
import com.umssonline.social.services.ParticipantService;
import com.umssonline.social.services.RateService;
import com.umssonline.social.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Collection;

@Service("rateService")
public class RateServiceImpl implements RateService {

    //region Properties
    @Autowired
    private ExtendedRateDao rateDao;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ParticipantService participantService;
    //endregion

    //region CrudSocialService Members
    @Transactional(readOnly = true)
    @Override
    public Rate findById(Serializable id) {
        return rateDao.findById(id);
    }

    @Override
    public Collection<Rate> findByProperty(String propertyName) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Rate> findAll() {
        return rateDao.findAll();
    }

    @Transactional
    @Override
    public Rate save(Rate rate) {

        if (rate.getScore() == null || rate.getCreatedBy() == null) {
            throw new EntityNotFoundException("Neither Resource nor CreatedBy properties can be null.");
        }

        Score scoreFromDb = scoreService.findById(rate.getScore().getId());
        if (scoreFromDb == null) {
            throw new EntityNotFoundException("Score can not be created, it does not have a related Score.");
        }

        Participant participantFromDb = participantService.findById(rate.getCreatedBy().getId());
        if (participantFromDb == null) {
            throw new EntityNotFoundException("The owner who is rating the resource does not exists.");
        }

        rate.setScore(scoreFromDb);
        rate.setCreatedBy(participantFromDb);

        return rateDao.create(rate);
    }

    @Transactional
    @Override
    public Rate update(Rate rate) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Rate rate) {
        rateDao.deleteById(rate.getId());
    }

    @Transactional
    @Override
    public void deleteById(Serializable id) {
        rateDao.deleteById(id);
    }
    //endregion

}

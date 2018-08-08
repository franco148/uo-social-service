package com.umssonline.social.services.impl;

import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.models.entity.Resource;
import com.umssonline.social.models.entity.Share;
import com.umssonline.social.repositories.api.ExtendedShareDao;
import com.umssonline.social.services.ParticipantService;
import com.umssonline.social.services.ResourceService;
import com.umssonline.social.services.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Collection;

@Service("shareService")
public class ShareServiceImpl implements ShareService {

    //region Properties
    @Autowired
    private ExtendedShareDao shareDao;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ParticipantService participantService;
    //endregion

    //region CrudSocialService Members
    @Override
    public Share findById(Serializable id) {
        return shareDao.findById(id);
    }

    @Override
    public Collection<Share> findByProperty(String propertyName) {
        return null;
    }

    @Override
    public Collection<Share> findAll() {
        return shareDao.findAll();
    }

    @Override
    public Share save(Share share) {

        if (share.getSharedResource() == null || share.getCreatedBy() == null) {
            throw new EntityNotFoundException("Neither Resource nor CreatedBy properties can be null.");
        }

        Resource resourceFromDb = resourceService.findById(share.getSharedResource().getId());
        if (resourceFromDb == null) {
            throw new EntityNotFoundException("Share can not be created, it does not have a related Resource");
        }

        Participant participantFromDb = participantService.findById(share.getCreatedBy().getId());
        if (participantFromDb == null) {
            throw new EntityNotFoundException("The owner who is creating the share does not exists.");
        }

        share.setSharedResource(resourceFromDb);
        share.setCreatedBy(participantFromDb);

        return shareDao.create(share);
    }

    @Override
    public Share update(Share share) {
        return null;
    }

    @Override
    public void delete(Share share) {
        shareDao.deleteById(share.getId());
    }

    @Override
    public void deleteById(Serializable id) {
        shareDao.deleteById(id);
    }
    //endregion
}

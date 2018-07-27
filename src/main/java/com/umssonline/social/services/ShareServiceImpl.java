package com.umssonline.social.services;

import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.models.entity.Resource;
import com.umssonline.social.models.entity.Share;
import com.umssonline.social.repositories.api.ExtendedShareDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

@Service("shareService")
public class ShareServiceImpl implements SocialService<Share> {

    //region Properties
    @Autowired
    private ExtendedShareDao shareDao;

    @Autowired
    private SocialService<Resource> resourceService;

    @Autowired
    private SocialService<Participant> participantService;
    //endregion

    //region SocialService Members
    @Override
    public Share findById(Serializable id) throws Exception {
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
    public Share save(Share share) throws Exception {

        if (share.getSharedResource() == null || share.getCreatedBy() == null) {
            throw new Exception("Neither Resource nor CreatedBy properties can be null.");
        }

        Resource resourceFromDb = resourceService.findById(share.getSharedResource().getId());
        if (resourceFromDb == null) {
            throw new Exception("Share can not be created, it does not have a related Resource");
        }

        Participant participantFromDb = participantService.findById(share.getCreatedBy().getId());
        if (participantFromDb == null) {
            throw new Exception("The owner who is creating the share does not exists.");
        }

        share.setSharedResource(resourceFromDb);
        share.setCreatedBy(participantFromDb);

        return shareDao.create(share);
    }

    @Override
    public Share update(Share share) throws Exception {
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

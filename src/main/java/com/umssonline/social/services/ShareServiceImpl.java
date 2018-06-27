package com.umssonline.social.services;

import com.umssonline.social.models.Share;
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
    //endregion

    //region SocialService Members
    @Override
    public Share findById(Serializable id) throws Exception {
        return null;
    }

    @Override
    public Collection<Share> findByProperty(String propertyName) {
        return null;
    }

    @Override
    public Collection<Share> findAll() {
        return null;
    }

    @Override
    public Share save(Share share) throws Exception {
        return null;
    }

    @Override
    public Share update(Share share) throws Exception {
        return null;
    }

    @Override
    public void delete(Share share) {

    }

    @Override
    public void deleteById(Serializable id) {

    }
    //endregion
}

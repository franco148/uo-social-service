package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.repositories.api.ExtendedParticipantDao;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantDaoImpl extends AbstractJpaDao<Participant> implements ExtendedParticipantDao {

    //region Constructors

    public ParticipantDaoImpl() {
        super();
        setClazz(Participant.class);
    }

    //endregion
}

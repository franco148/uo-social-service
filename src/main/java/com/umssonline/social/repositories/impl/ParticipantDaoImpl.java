package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.Participant;
import com.umssonline.social.repositories.api.ExtendedParticipantDao;

public class ParticipantDaoImpl extends AbstractJpaDao<Participant> implements ExtendedParticipantDao {

    //region Constructors

    public ParticipantDaoImpl() {
        super();
        setClazz(Participant.class);
    }

    //endregion
}

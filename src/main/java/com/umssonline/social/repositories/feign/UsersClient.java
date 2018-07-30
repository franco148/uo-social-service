package com.umssonline.social.repositories.feign;

import com.umssonline.social.models.dto.participant.ParticipantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("AUTH-SERVICE")
public interface UsersClient {

    @RequestMapping
    (
        value = "/{user_id}",
        method = RequestMethod.GET
    )
    ParticipantDto findParticipant(@PathVariable("user_id") final Long participantId);
}

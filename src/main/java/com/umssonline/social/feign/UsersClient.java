package com.umssonline.social.feign;

import com.umssonline.social.models.dto.participant.ParticipantDto;
import com.umssonline.social.models.entity.Participant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("AUTH-SERVICE")
public interface UsersClient {

    @RequestMapping
    (
        value = "/users/{user_id}",
        method = RequestMethod.GET
    )
    ParticipantDto findParticipantDto(@PathVariable("user_id") final Long participantId);

    @RequestMapping
    (
        value = "/users/{user_id}",
        method = RequestMethod.GET,
        consumes = {"application/json"}
    )
    Participant findParticipant(@PathVariable("user_id") final Long participantId);
}

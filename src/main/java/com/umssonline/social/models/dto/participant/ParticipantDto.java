package com.umssonline.social.models.dto.participant;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ParticipantDto {

    private Long id;
    private String name;
    private String lastName;
    private String nickName;
    private String account;

    private Set<RoleDto> userRoles = new HashSet<>();
}

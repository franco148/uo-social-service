package com.umssonline.social.repositories.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("AUTH-SERVICE")
public interface UsersClient {
}

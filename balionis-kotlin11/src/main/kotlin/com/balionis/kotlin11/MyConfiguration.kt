package com.balionis.kotlin11

import org.springframework.beans.factory.InitializingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.activiti.engine.IdentityService
import org.activiti.engine.identity.User
import org.activiti.engine.identity.Group

@Configuration
class MyConfiguration {

    @Bean
    fun usersAndGroupsInitializer(identityService: IdentityService): InitializingBean? {
        return InitializingBean {
            val group: Group = identityService.newGroup("user").apply {
                name = "ROLE_USER"
                type = "USER"
            }
            identityService.saveGroup(group)
            val test: User = identityService.newUser("test").apply {
                password = "1234"
            }
            identityService.saveUser(test)
            identityService.createMembership(test.id, group.id);
        }
    }
}
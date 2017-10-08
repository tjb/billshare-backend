package com.billshare.app.config.data

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManagerFactory

@Configuration
class DataConfig {
    @Bean
    fun sessionFactory(@Autowired entityManagerFactory: EntityManagerFactory) :
            SessionFactory = entityManagerFactory.unwrap(SessionFactory::class.java)
}
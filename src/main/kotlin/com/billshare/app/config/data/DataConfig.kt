package com.billshare.app.config.data

import org.hibernate.SessionFactory
import org.hibernate.jpa.HibernateEntityManagerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataConfig {
    @Bean
    fun sessionFactory(hemf: HibernateEntityManagerFactory): SessionFactory {
        return hemf.getSessionFactory()
    }
}
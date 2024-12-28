package com.adolphus.incident.model.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * set auditor info for spring jpa
 * @author Zhang Chi
 * @date 2024-12-27
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "springJpaAuditor")
public class AuditConfiguration {

    /**
     * in real project, should get auditor from spring security or other place for current login user
     * @return auditor
     */
    @Bean
    public AuditorAware<String> springJpaAuditor() {
        return () -> Optional.of("demo");
    }
}

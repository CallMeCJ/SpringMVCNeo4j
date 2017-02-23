package com.cjzheng.neo4j;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.cjzheng.neo4j.repository")
@EnableTransactionManagement
@ComponentScan("com.cjzheng.neo4j")
public class AppConfiguration extends Neo4jConfiguration {

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.cjzheng.neo4j.domain");// with domain entity base package(s)
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return super.getSession();
    }
}
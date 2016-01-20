package com.martinrist.springInAction.chapter11.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.support.Neo4jEmbeddedTransactionManager;

import javax.transaction.TransactionManager;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.martinrist.springInAction.chapter11.neo4j")
public class Neo4jConfig extends Neo4jConfiguration {

    public Neo4jConfig() {
        setBasePackage("com.martinrist.springInAction.chapter11.neo4j");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("/tmp/graphdb");
    }

    @Bean
    public TransactionManager transactionManager(GraphDatabaseService gdbs) {
        return new Neo4jEmbeddedTransactionManager(gdbs);
    }
}

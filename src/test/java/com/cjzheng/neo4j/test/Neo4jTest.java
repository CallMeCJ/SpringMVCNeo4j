package com.cjzheng.neo4j.test;

import com.cjzheng.neo4j.PersistenceContext;
import com.cjzheng.neo4j.domain.Actor;
import com.cjzheng.neo4j.repository.ActorRepository;
import com.cjzheng.neo4j.service.Neo4jDBCleaner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class Neo4jTest {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    Neo4jDBCleaner cleaner;

    @Test
    public void databaseShouldBeCleared() {
        Actor tomHanks = new Actor("1", "Tom Hanks");
        actorRepository.save(tomHanks);
        System.out.println("保存一条记录成功");
        cleaner.cleanDb();
        System.out.println("清空数据库");
    }

}

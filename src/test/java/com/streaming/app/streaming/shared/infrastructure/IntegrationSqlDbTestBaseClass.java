package com.streaming.app.streaming.shared.infrastructure;

import jakarta.transaction.Transactional;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest()
@Transactional
//@SpringBootTest()
public abstract class IntegrationSqlDbTestBaseClass implements IntegrationTestBaseClass{

}
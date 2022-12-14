package net.flexberry.flexberrySampleSpring.service;

import net.flexberry.flexberrySampleSpring.model.TestEntity;
import net.flexberry.flexberrySampleSpring.repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TestEntityService {
    @Autowired
    TestEntityRepository repository;

    public TestEntity getTestEntity(int primaryKey) {
        return repository.findById(primaryKey).get();
    }
    public List<TestEntity> getEnabledTestEntities() {
        return repository.findByEnabled(true);
    }

    public void saveOrUpdateTestEntity(TestEntity testEntity) {
        repository.save(testEntity);
    }

    public void deleteTestEntityByPrimaryKey(int primaryKey) {
        repository.deleteById(primaryKey);
    }
}

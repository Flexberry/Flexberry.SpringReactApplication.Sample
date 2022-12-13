package net.flexberry.flexberrySampleSpring.services;

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

    public TestEntity getTestEntityById(UUID id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdateTestEntity(TestEntity testEntity) {
        repository.save(testEntity);
    }

    public void deleteTestEntityById(UUID id) {
        repository.deleteById(id);
    }

    public List<TestEntity> getTestEntitiesByName(String name) {
        return repository.findByName(name);
    }

    public List<TestEntity> getTestEntitiesByEnabled(boolean enabled) {
        return repository.findByEnabled(enabled);
    }
}

package net.flexberry.flexberrySampleSpring.web.rest;

import net.flexberry.flexberrySampleSpring.model.TestEntity;
import net.flexberry.flexberrySampleSpring.services.TestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TestEntityController {
    @Autowired
    TestEntityService service;

    @GetMapping("/testentity/{id}")
    public TestEntity getTestEntity(@PathVariable("id") UUID id) {
        return service.getTestEntityById(id);
    }

    @DeleteMapping("/testentity/{id}")
    public void deleteTestEntity(@PathVariable("id") UUID id) {
        service.deleteTestEntityById(id);
    }

    @PostMapping("/testentity")
    public void addTestEntity(@RequestBody TestEntity entity) {
        service.saveOrUpdateTestEntity(entity);
    }

    @PutMapping("/testentity")
    public void updateTestEntity(@RequestBody TestEntity entity) {
        service.saveOrUpdateTestEntity(entity);
    }
}

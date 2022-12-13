package net.flexberry.flexberrySampleSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.flexberry.flexberrySampleSpring.model.TestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/*
    Класс репозитория. Этот класс реализует базовые методы работы с сущностями:
    save(), findOne(), findById(), findAll(), count(), delete(), deleteById()…
    без дополнительного их объявления.
 */
@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, UUID> {

    // Кроме базовых методов можно добавлять кастомные. Этот метод возвращает сущности с указанным типом enabled.
    List<TestEntity> findByEnabled(boolean enabled);

    // А этот возвращает сущности с заданным именем.
    List<TestEntity> findByName(String name);
}
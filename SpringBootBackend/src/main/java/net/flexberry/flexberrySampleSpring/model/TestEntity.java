package net.flexberry.flexberrySampleSpring.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "testentity")
public class TestEntity {
    @Id
    @Column(name = "primarykey")
    private int primarykey;

    @Column(name = "name")
    private String name;

    @Column(name = "points")
    private int points;

    @Column(name = "enabled")
    private boolean enabled;

    public TestEntity() {
        super();
    }

    public void setprimaryKey(int primarykey) {
        this.primarykey = primarykey;
    }

    public int getprimarykey() {
        return primarykey;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getpoints() {
        return points;
    }

    public void setpoints(int points) {
        this.points = points;
    }

    public boolean getenabled() {
        return enabled;
    }

    public void setenabled(boolean enabled) {
        this.enabled = enabled;
    }
}

package org.example.eclipselink_example;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CACHETEST.CACHETEST")
public class CacheTestObject implements Serializable {
    @Id
    @QuerySqlField
    private Long id;
    @QuerySqlField
    private String firstName;
    @QuerySqlField
    private String lastName;

    public CacheTestObject() {}

    public CacheTestObject(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

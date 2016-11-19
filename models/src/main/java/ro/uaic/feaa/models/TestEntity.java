package ro.uaic.feaa.models;

import javax.persistence.*;

@Entity
@Table(name = "first_entity")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "_id")
    private Long id;

    @Column(name = "field", nullable = false)
    private String field;

    @Column(name = "second_field")
    private String secondField;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSecondField() {
        return secondField;
    }

    public void setSecondField(String secondField) {
        this.secondField = secondField;
    }
}

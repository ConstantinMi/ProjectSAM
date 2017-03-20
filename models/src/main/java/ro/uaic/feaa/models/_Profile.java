package ro.uaic.feaa.models;

import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "_profiles")
public class _Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Field
    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "profile")
    private Set<_Subscriber> subscribers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<_Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<_Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}

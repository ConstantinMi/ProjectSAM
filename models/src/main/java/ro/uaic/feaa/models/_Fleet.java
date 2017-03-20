package ro.uaic.feaa.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "_fleets")
public class _Fleet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "fleet")
    private Set<_Subscriber> subscribers = new HashSet<>();

    @Column(name = "fleet_name")
    private String fleetName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<_Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<_Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }
}

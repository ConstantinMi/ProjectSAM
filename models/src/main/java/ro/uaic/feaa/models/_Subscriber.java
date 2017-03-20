package ro.uaic.feaa.models;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;

@Entity
@Table(name = "_subscribers")
@Indexed
public class _Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Column(name = "subscriber_type")
    private String type;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String identity;
    private String name;

    @IndexedEmbedded
    @ManyToOne
    @JoinColumn
    private _Profile profile;

    @ManyToOne
    @JoinColumn
    private _Fleet fleet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public _Profile getProfile() {
        return profile;
    }

    public void setProfile(_Profile profile) {
        this.profile = profile;
    }

    public _Fleet getFleet() {
        return fleet;
    }

    public void setFleet(_Fleet fleet) {
        this.fleet = fleet;
    }
}

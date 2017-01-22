package ro.uaic.feaa.models;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Subselect;
import ro.uaic.feaa.models.composite_key.EmbeddedKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Claudiu on 1/12/2017.
 */
@Entity
@Table(name = "user_project")
public class ProjectUser {

    @EmbeddedId
    private EmbeddedKey embeddedKey;

    public EmbeddedKey getEmbeddedKey() {
        return embeddedKey;
    }

    public void setEmbeddedKey(EmbeddedKey embeddedKey) {
        this.embeddedKey = embeddedKey;
    }
}

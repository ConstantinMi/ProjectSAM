package ro.uaic.feaa.models;


import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import ro.uaic.feaa.enums.FeatureState;
import ro.uaic.feaa.enums.IssueType;
import ro.uaic.feaa.enums.Priority;

import javax.persistence.*;

@Entity
@Table(name = "subfeature")
public class SubFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Feature feature;

    @Column(name = "subfeature_title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "feature_state")
    @Enumerated(value = EnumType.STRING)
    private FeatureState state;

    @Column(name = "issue_type")
    @Enumerated(value = EnumType.STRING)
    private IssueType issueType;

    @OneToOne
    @JoinColumn(name = "asignee_person_id")
    private Person asignee;

    @OneToOne
    @JoinColumn(name = "reporter_person_id")
    private Person reporter;

    @Column(name = "created")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime created;

    @Column(name = "updated")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updated;

    @Column(name = "comment")
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FeatureState getState() {
        return state;
    }

    public void setState(FeatureState state) {
        this.state = state;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public Person getAsignee() {
        return asignee;
    }

    public void setAsignee(Person asignee) {
        this.asignee = asignee;
    }

    public Person getReporter() {
        return reporter;
    }

    public void setReporter(Person reporter) {
        this.reporter = reporter;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public DateTime getUpdated() {
        return updated;
    }

    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package ro.uaic.feaa.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import ro.uaic.feaa.enums.FeatureState;
import ro.uaic.feaa.enums.IssueType;
import ro.uaic.feaa.enums.Priority;

import javax.persistence.*;

@Entity
@Table(name = "project_feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "_id", nullable = false)
    private Long id;

    @Column(name = "feature_title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    @Enumerated(value = EnumType.STRING)
    private Priority priority;

    @Column(name = "feature_state")
    @Enumerated(value = EnumType.STRING)
    private FeatureState state;

    @Column(name = "story_points")
    private Integer storyPoints;

    @Column(name = "issue_type")
    @Enumerated(value = EnumType.STRING)
    private IssueType issueType;

    @OneToOne
    @JoinColumn(name = "asignee_person_id")
    private Person asignee;

    @OneToOne
    @JoinColumn(name = "reporter_person_id")
    private Person reporter;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "created")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime created;

    @Column(name = "updated")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updated;

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    @Column(name = "comment")
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(Integer storyPoints) {
        this.storyPoints = storyPoints;
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

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
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
}

package ro.uaic.feaa.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import ro.uaic.feaa.enums.FeatureState;
import ro.uaic.feaa.enums.IssueType;
import ro.uaic.feaa.enums.Priority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project_feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
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
    @Fetch(FetchMode.JOIN)
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

    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "feature")
    private Set<SubFeature> subFeatures = new HashSet<>();

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", state=" + state +
                ", storyPoints=" + storyPoints +
                ", issueType=" + issueType +
                ", asignee=" + asignee +
                ", reporter=" + reporter +
                ", project=" + project +
                ", created=" + created +
                ", updated=" + updated +
                ", sprint=" + sprint +
                ", comment='" + comment + '\'' +
                ", subFeatures=" + subFeatures +
                '}';
    }

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

    public Set<SubFeature> getSubFeatures() {
        return subFeatures;
    }

    public void setSubFeatures(Set<SubFeature> subFeatures) {
        this.subFeatures = subFeatures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feature feature = (Feature) o;

        if (id != null ? !id.equals(feature.id) : feature.id != null) return false;
        if (title != null ? !title.equals(feature.title) : feature.title != null) return false;
        if (description != null ? !description.equals(feature.description) : feature.description != null) return false;
        if (priority != feature.priority) return false;
        if (state != feature.state) return false;
        if (storyPoints != null ? !storyPoints.equals(feature.storyPoints) : feature.storyPoints != null) return false;
        if (issueType != feature.issueType) return false;
        if (asignee != null ? !asignee.equals(feature.asignee) : feature.asignee != null) return false;
        if (reporter != null ? !reporter.equals(feature.reporter) : feature.reporter != null) return false;
        if (project != null ? !project.equals(feature.project) : feature.project != null) return false;
        if (created != null ? !created.equals(feature.created) : feature.created != null) return false;
        if (updated != null ? !updated.equals(feature.updated) : feature.updated != null) return false;
        if (sprint != null ? !sprint.equals(feature.sprint) : feature.sprint != null) return false;
        if (comment != null ? !comment.equals(feature.comment) : feature.comment != null) return false;
        return subFeatures != null ? subFeatures.equals(feature.subFeatures) : feature.subFeatures == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (storyPoints != null ? storyPoints.hashCode() : 0);
        result = 31 * result + (issueType != null ? issueType.hashCode() : 0);
        result = 31 * result + (asignee != null ? asignee.hashCode() : 0);
        result = 31 * result + (reporter != null ? reporter.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (sprint != null ? sprint.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (subFeatures != null ? subFeatures.hashCode() : 0);
        return result;
    }
}

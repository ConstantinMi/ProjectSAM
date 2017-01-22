package ro.uaic.feaa.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "sprint")
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startDate;

    @Column(name = "end_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endDate;

    @Column(name = "sprint_number", nullable = false)
    private String sprintNo;

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", sprintNo='" + sprintNo + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public String getSprintNo() {
        return sprintNo;
    }

    public void setSprintNo(String sprintNo) {
        this.sprintNo = sprintNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sprint sprint = (Sprint) o;

        if (id != null ? !id.equals(sprint.id) : sprint.id != null) return false;
        if (startDate != null ? !startDate.equals(sprint.startDate) : sprint.startDate != null) return false;
        if (endDate != null ? !endDate.equals(sprint.endDate) : sprint.endDate != null) return false;
        return sprintNo != null ? sprintNo.equals(sprint.sprintNo) : sprint.sprintNo == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (sprintNo != null ? sprintNo.hashCode() : 0);
        return result;
    }
}

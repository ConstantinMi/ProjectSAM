package ro.uaic.feaa.dto;

/**
 * Created by Claudiu on 12/13/2016.
 */
public class SprintDTO {

    private Long id;
    private String startDate;
    private String endDate;
    private String sprintNo;
    private Long noOfWeeks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSprintNo() {
        return sprintNo;
    }

    public void setSprintNo(String sprintNo) {
        this.sprintNo = sprintNo;
    }

    public Long getNoOfWeeks() {
        return noOfWeeks;
    }

    public void setNoOfWeeks(Long noOfWeeks) {
        this.noOfWeeks = noOfWeeks;
    }
}

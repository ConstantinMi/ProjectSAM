package ro.uaic.feaa.enums;

import ro.uaic.feaa.enums.util.Enums;

public enum IssueType implements Enums {
    TASK("Task"),
    STORY("Story"),
    BUG("Bug"),
    EPIC("Epic");

    private String issue;

    IssueType(String issue) {
        this.issue = issue;
    }


    @Override
    public String getKey() {
        return issue;
    }

    public static IssueType valueOfKey(String key) {
        if (key != null && !key.isEmpty()) {
            for (IssueType issueType : values()) {
                if (issueType.getKey().equals(key)) {
                    return issueType;
                }
            }
        }
        return null;
    }
}

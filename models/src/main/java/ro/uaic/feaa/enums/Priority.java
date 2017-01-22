package ro.uaic.feaa.enums;

import ro.uaic.feaa.enums.util.Enums;

public enum Priority implements Enums{

    HIGHEST("Highest"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low"),
    LOWEST("Lowest");

    private String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    @Override
    public String getKey() {
        return priority;
    }

    public static Priority valueOfKey(String key) {
        if (key != null && !key.isEmpty()) {
        for (Priority priority : values()) {
            if (priority.getKey().equals(key)) {
                return priority;
            }
        }
        }
        return null;
    }
}

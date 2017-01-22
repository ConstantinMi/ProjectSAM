package ro.uaic.feaa.enums;

import ro.uaic.feaa.enums.util.Enums;

public enum FeatureState implements Enums{
    TODO("To Do"),
    IN_PROGRESS("In progress"),
    TESTING("Testing"),
    DONE("Done");

    private String featureState;

    FeatureState(String feature) {
        this.featureState = feature;
    }

    @Override
    public String getKey() {
        return featureState;
    }

    public static FeatureState valueOfKey(String key) {
        if (key != null && !key.isEmpty()) {
            for (FeatureState featureState : values()) {
                if (key.equals(featureState.getKey())) {
                    return featureState;
                }
            }
        }
        return null;
    }
}

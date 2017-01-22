package ro.uaic.feaa.enums;

import ro.uaic.feaa.enums.util.Enums;

public enum Position implements Enums {

    TESTER("Tester Developer"),
    DEVELOPER("Software Developer"),
    ANALYST("Business Analyst"),
    PROJECT_MANAGER("Project Manager"),
    PRODUCT_MANAGER("Product Manager"),
    PRODUCT_OWNER("Product Owner");

    private String position;

    Position(String position) {
        this.position = position;
    }

    @Override
    public String getKey() {
        return position;
    }

    public static Position valueOfKey(String key) {
        if (key != null && !key.isEmpty()) {
            for (Position position : values()) {
                if (position.getKey().equals(key)) {
                    return position;
                }
            }
        }
        return null;
    }

}


public enum Gender {
    MALE("پیاگ"),

    FEMALE("خانم");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

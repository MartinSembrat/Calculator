package calculator.history_save_controllers;

public enum EMysqlProperties {
    DB_CONNECTION("jdbc:h2:file:./src/main/java/calculator/history/h2_database/h2_database"),
    DB_USER("sa"),
    DB_PASSWORD("");

    private final String value;
    private EMysqlProperties(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}

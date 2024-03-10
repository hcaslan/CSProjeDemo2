package org.bilgeadam.constant;

public enum Role {
    YONETICI("Yonetici"),
    MEMUR("Memur");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

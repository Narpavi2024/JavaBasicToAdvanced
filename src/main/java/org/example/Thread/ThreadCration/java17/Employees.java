package org.example.Thread.ThreadCration.java17;

public record Employees(String name ,String role) implements Describable {
    @Override
    public String describe() {
        return name+"is a "+role;
    }
}

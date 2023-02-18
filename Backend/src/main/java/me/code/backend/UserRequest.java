package me.code.backend;

import java.sql.Date;

public record UserRequest(String firstName, String lastName, Date birthDate) {
}

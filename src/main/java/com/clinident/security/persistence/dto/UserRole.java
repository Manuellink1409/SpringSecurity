package com.clinident.security.persistence.dto;

import java.util.Arrays;
import java.util.List;

public enum UserRole {

    ADMIN_ROLE(Arrays.asList(
            Permissions.CreateUser,
            Permissions.UpdateUser,
            Permissions.DeleteUser,
            Permissions.CreatePatient,
            Permissions.UpdatePatient,
            Permissions.DeletePatient,
            Permissions.ReadPatient,
            Permissions.ReadMyData
            )),
    DOCTOR_ROLE(Arrays.asList(
            Permissions.CreatePatient,
            Permissions.UpdatePatient,
            Permissions.ReadPatient,
            Permissions.ReadMyData
    )),
    SECRETARY_ROLE(Arrays.asList(
            Permissions.ReadPatient,
            Permissions.ReadMyData
    ));

    private List<Permissions> permissions;

    UserRole(List<Permissions> permissions) {
        this.permissions = permissions;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }
}

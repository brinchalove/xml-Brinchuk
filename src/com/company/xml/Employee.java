package com.company.xml;

import java.util.Objects;

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String tag;
    private Byte userRoleId;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public Byte getUserRoleId() {
        return userRoleId;
    }
    public void setUserRoleId(Byte userRoleId) {
        this.userRoleId = userRoleId;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
                + phoneNumber + ", password=" + password + ", tag=" + tag + ", userRoleId=" + userRoleId + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, id, lastName, password, phoneNumber, tag, userRoleId);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
                && Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
                && Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(tag, other.tag)
                && Objects.equals(userRoleId, other.userRoleId);
    }

}

package com.technologiyagroup.tutnav.model;

public class Employee {
    String empId;
    String eName;
    String dept;
    String doj;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public Employee(String empId, String eName, String dept, String doj) {
        this.empId = empId;
        this.eName = eName;
        this.dept = dept;
        this.doj = doj;
    }
}
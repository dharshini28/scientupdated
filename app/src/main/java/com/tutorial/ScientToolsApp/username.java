package com.tutorial.ScientToolsApp;
public class username {
    String name,department,rollno,tool;
    public username(String name,String department,String rollno,String tool){
        this.name=name;
        this.department=department;
        this.rollno=rollno;
        this.tool=tool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}
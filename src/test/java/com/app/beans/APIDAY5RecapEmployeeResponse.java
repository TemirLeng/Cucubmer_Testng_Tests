package com.app.beans;

import java.util.ArrayList;
import java.util.Map;
public class APIDAY5RecapEmployeeResponse {
private String first_name;
private String last_name;
private String email;
private String phone_num;
private int employee_id;
private int manager_id;
private int salary;
private String hire_date;
private String commission_pct;
private int department_id;
private String job_id;
private ArrayList<Map<String,String>>links;

public ArrayList<Map<String, String>> getLinks() {
	return links;
}
public void setLinks(ArrayList<Map<String, String>> links) {
	this.links = links;
}
public String getJob_id() {
	return job_id;
}
public void setJob_id(String job_id) {
	this.job_id = job_id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone_num() {
	return phone_num;
}
public void setPhone_number(String phone_num) {
	this.phone_num = phone_num;
}
public int getEmployee_id() {
	return employee_id;
}
public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
}
public int getManager_id() {
	return manager_id;
}
public void setManager_id(int manager_id) {
	this.manager_id = manager_id;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getHire_date() {
	return hire_date;
}
public void setHire_date(String hire_date) {
	this.hire_date = hire_date;
}
public String getCommission_pct() {
	return commission_pct;
}
public void setCommission_pct(String commission_pct) {
	this.commission_pct = commission_pct;
}
public int getDepartment_id() {
	return department_id;
}
public void setDepartment_id(int department_id) {
	this.department_id = department_id;
}


}

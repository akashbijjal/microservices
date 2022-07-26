package com.hr;





public class employee {

	private long id;
	private String empname;
	private int salary;
private int depid;
public employee(long id, String empname, int salary, int depid) {
	super();
	this.id = id;
	this.empname = empname;
	this.salary = salary;
	this.depid = depid;
}
public employee() {
	super();
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public int getDepid() {
	return depid;
}
public void setDepid(int depid) {
	this.depid = depid;
}



}

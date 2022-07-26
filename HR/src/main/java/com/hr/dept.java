package com.hr;


public class dept {
private long deptid;
private String dname;
private int locid;
public long getDeptid() {
	return deptid;
}
public void setDeptid(long deptid) {
	this.deptid = deptid;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public int getLocid() {
	return locid;
}
public void setLocid(int locid) {
	this.locid = locid;
}
public dept() {
	super();
}
public dept(long deptid, String dname, int locid) {
	super();
	this.deptid = deptid;
	this.dname = dname;
	this.locid = locid;
}
@Override
public String toString() {
	return "dept [deptid=" + deptid + ", dname=" + dname + ", locid=" + locid + "]";
}



}

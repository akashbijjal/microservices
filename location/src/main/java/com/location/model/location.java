package com.location.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "location")
public class location {
private long locid;
private String locname;
public long getLocid() {
	return locid;
}
public void setLocid(long locid) {
	this.locid = locid;
}
public String getLocname() {
	return locname;
}
public void setLocname(String locname) {
	this.locname = locname;
}
public location(long locid, String locname) {
	super();
	this.locid = locid;
	this.locname = locname;
}
public location() {
	super();
}

@Override
public String toString() {
	return "location [locid=" + locid + ", locname=" + locname + "]";
}



}

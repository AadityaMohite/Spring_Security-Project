package com.Aadi.execption;

public class EmployeeNotFoundException extends RuntimeException {
  public EmployeeNotFoundException(String msg) {
	  super(msg);
  }
}

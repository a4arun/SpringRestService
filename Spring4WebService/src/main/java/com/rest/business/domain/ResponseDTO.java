/**
 * 
 */
package com.rest.business.domain;

/**
 * @author Admin
 *
 */
public class ResponseDTO {

	
	private int userid;

	private String firstName;

	private String lastName;

	private String email;
	
	
	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * 
	 */
	public ResponseDTO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "RequestDTO [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}

	
}

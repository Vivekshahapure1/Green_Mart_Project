package com.app.payload.request;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Lazy;
@Lazy(value = false)
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role = new HashSet<String>();
    
    
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotNull
    private long contact;
    
    
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public Set<String> getRole() {
		System.out.println("in role getter :"+role.toString());
      return this.role;
    }
    
    public void setRole(Set<String> role) {
    	System.out.println("in role setter :"+role.toString());
      this.role = role;
    }
}

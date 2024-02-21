package org.mypackage;



public class Admin {

        String username;
        String password;
        String email;
        String phone;

        public Admin(String user, String pass, String email, String phone) {
        	this.username = user;
        	this.password = pass;
        	this.email = email;
        	this.phone = phone;
        }
		public String getUsername() {
			return username;
		}
    }
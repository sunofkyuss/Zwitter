package sunofkyuss.zwitter.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sunofkyuss.zwitter.beans.RegisterService;
import sunofkyuss.zwitter.view.utility.Messages;

@Named
@ViewScoped
public class RegisterView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RegisterService rs;
	
	private String username, password, passwordCorrection;
	
	@PostConstruct
	public void init(){
		
	}

	public void register(){
		
		if(!password.equals(passwordCorrection)){
			Messages.error("Error!","");
			return;
		}
		
		if(!rs.register(username, password)){
			Messages.error("Error!", "");
			return;
		}
		
		Messages.info("Success!", "");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCorrection() {
		return passwordCorrection;
	}

	public void setPasswordCorrection(String passwordCorrection) {
		this.passwordCorrection = passwordCorrection;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}

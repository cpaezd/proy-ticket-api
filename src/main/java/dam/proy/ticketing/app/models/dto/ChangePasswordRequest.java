package dam.proy.ticketing.app.models.dto;

public class ChangePasswordRequest
{
	private String newPassword;
	private String email;
	private String token;

	public ChangePasswordRequest() {}

	public ChangePasswordRequest(String newPassword, String email, String token) {
		this.newPassword = newPassword;
		this.email = email;
		this.token = token;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

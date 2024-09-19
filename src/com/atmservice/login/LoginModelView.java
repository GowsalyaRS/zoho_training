package com.atmservice.login;

public class LoginModelView {

    private LoginView loginView;
	LoginModelView(LoginView loginView) 
    {
		this.loginView = loginView;
	}
    public void validateCheck(String username, String password) 
    {
       
        if(username.equals("zoho")) 
        {
            if(password.equals("1234"))
            {
               loginView.onSuccess();
            }
            else
            {
                loginView.alert("Passord Invalid!");
            }
        }
        else
        {
            loginView.alert("Username Invalid");
        }
    }
}

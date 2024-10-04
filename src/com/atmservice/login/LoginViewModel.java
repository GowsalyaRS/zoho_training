package com.atmservice.login;

public class LoginViewModel  implements LoginViewModelProcess
{
    private LoginViewProcess loginView;
    public void setLoginView(LoginViewProcess loginView) 
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
                LoginView.alert("Passord Invalid!");
            }
        }
        else
        {
            LoginView.alert("Username Invalid");
        }
    }
}

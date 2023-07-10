package controllers;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

import java.util.Optional;

public class Secured extends Security.Authenticator{

    @Override
    public Optional<String> getUsername(Http.Request req){
        return req.session().get("connected");
    }

    @Override
    public Result onUnauthorized(Http.Request request){
        return redirect(routes.LoginController.showLoginForm());
    }

}
package controllers;

import play.mvc.*;

import javax.inject.Inject;

public class HomeController extends Controller{

    @Inject
    public HomeController(){

    }

    //@Security.Authenticated(Secured.class)
    public Result index(){
        return ok(views.html.index.render());
    }
}
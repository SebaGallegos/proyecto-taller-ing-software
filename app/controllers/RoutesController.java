package controllers;

import play.mvc.Result;
import play.mvc.Controller;
import play.mvc.Security;

public class RoutesController extends Controller{

    @Security.Authenticated(Secured.class)
    public Result phone(){
        return ok(views.html.phone.render());
    }

    @Security.Authenticated(Secured.class)
    public Result spidey(){
        return ok(views.html.spidey.render());
    }

    @Security.Authenticated(Secured.class)
    public Result leon(){
        return ok(views.html.leon.render());
    }
}

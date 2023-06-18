package controllers;

import play.mvc.Result;
import play.mvc.Controller;

public class RoutesController extends Controller{

    public Result phone(){
        return ok(views.html.phone.render());
    }

}

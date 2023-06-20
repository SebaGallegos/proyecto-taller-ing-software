package controllers;

import models.User;
import play.i18n.MessagesApi;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

public class LoginController extends Controller{

    private final FormFactory formFactory;
    private MessagesApi messagesApi;

    @Inject
    public LoginController(FormFactory formFactory, MessagesApi messagesApi){
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }

    public Result showLoginForm(Http.Request request){
        Form<UserProcess> form = formFactory.form(UserProcess.class);
        return ok(views.html.login.render(form, request, messagesApi.preferred(request)));
    }

    public Result processLogin(Http.Request request){
        Form<UserProcess> form = formFactory.form(UserProcess.class).bindFromRequest(request);
        UserProcess user = form.get();

        boolean verify = verify(user.getEmail(), user.getPassword());

        if (verify){
            return redirect(routes.HomeController.index()).addingToSession(request, "connected", user.getEmail());
        } else{
            return redirect(routes.LoginController.showLoginForm());
        }
    }

    //@Security.Authenticated(Secured.class)
    public Result logout(Http.Request request){
        return redirect(routes.LoginController.showLoginForm()).removingFromSession(request, "connected");
    }

    private boolean verify(String email, String password){
        User user = User.find.query().where()
                .eq("email", email)
                .eq("password", password)
                .findOne();

        return user != null;
    }
}

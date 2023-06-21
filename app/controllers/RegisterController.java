package controllers;

import models.User;
import play.i18n.MessagesApi;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

public class RegisterController extends Controller {

    private final FormFactory formFactory;
    private final MessagesApi messagesApi;

    @Inject
    public RegisterController(FormFactory formFactory, MessagesApi messagesApi) {
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }

    public Result showRegistrationForm(Http.Request request) {
        Form<UserProcess> form = formFactory.form(UserProcess.class);
        return ok(views.html.register.render(form, request, messagesApi.preferred(request)));
    }


    public Result processRegistration(Http.Request request) {
        Form<UserProcess> form = formFactory.form(UserProcess.class).bindFromRequest(request);
        UserProcess user = form.get();

        User newUser = new User();
        newUser.email = user.getEmail();
        newUser.password = user.getPassword();
        newUser.save();

        return redirect(routes.LoginController.showLoginForm());
    }
}

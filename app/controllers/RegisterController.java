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

        // Validar los datos de registro aquí
        /*if (!validateRegistrationData(user)) {
            return redirect(routes.RegisterController.showRegistrationForm()).flashing("error", "Datos de registro inválidos");
        }*/

        User newUser = new User();
        newUser.email = user.getEmail();
        newUser.password = user.getPassword();

        newUser.save();
        // Guardar el nuevo usuario en la base de datos o realizar otras acciones necesarias

        return redirect(routes.LoginController.showLoginForm());
    }

    /*public Result registrationSuccess() {
        return ok("Registro exitoso");
    }
*/
    /*private boolean validateRegistrationData(UserProcess user) {
        // Validar los datos de registro aquí
        return true;
    }*/
}

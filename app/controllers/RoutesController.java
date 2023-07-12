package controllers;

import models.Oferta;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Controller;
import play.mvc.Security;

import javax.inject.Inject;
import java.util.Optional;

public class RoutesController extends Controller{

    private final FormFactory formFactory;
    private MessagesApi messagesApi;

    @Inject
    public RoutesController(FormFactory formFactory, MessagesApi messagesApi){
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }

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

    @Security.Authenticated(Secured.class)
    public Result mostrarFormOferta(Http.Request req){
        Form<OfertaProcess> form = formFactory.form(OfertaProcess.class);
        return ok(views.html.oferta.render(form, req, messagesApi.preferred(req)));
    }

    @Security.Authenticated(Secured.class)
    public Result enviarOferta(Http.Request req){
        Form<OfertaProcess> form = formFactory.form(OfertaProcess.class).bindFromRequest(req);
        OfertaProcess ofertaForm = form.get();

        Oferta newOferta = new Oferta();
        if (getIDfromDB(req) != -1) {
            newOferta.idEmpresaCHI = ofertaForm.getIdEmpresaCHI();
            newOferta.idEmpresaEXT = getIDfromDB(req);
            newOferta.detalle = ofertaForm.getDetalle();
            newOferta.save();

            return redirect(routes.HomeController.index());
        } else {
            return redirect(routes.RoutesController.mostrarFormOferta());
        }
    }

    @Security.Authenticated(Secured.class)
    private int getIDfromDB(Http.Request req) {
        Optional<String> connected = req.session().get("connected");
        if (connected.isPresent()) {
            String email = connected.get();
            User user = User.find.query().where()
                    .eq("email", email)
                    .findOne();

            if (user != null) {
                return user.id;
            }
        }
        return -1;
    }

}

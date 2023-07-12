package controllers;

import models.Oferta;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Controller;
import play.mvc.Security;

import javax.inject.Inject;

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
        newOferta.idEmpresaCHI = ofertaForm.getIdEmpresaCHI();
        newOferta.idEmpresaEXT = ofertaForm.getIdEmpresaEXT();
        newOferta.detalle = ofertaForm.getDetalle();
        newOferta.save();

        return redirect(routes.HomeController.index());

    }
}

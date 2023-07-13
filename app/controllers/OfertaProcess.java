package controllers;

public class OfertaProcess {

    protected int idEmpresaCHI;
    protected int idEmpresaEXT;
    protected String detalle;

    public OfertaProcess(){

    }

    public void setIdEmpresaCHI(int idEmpresaCHI) {
        this.idEmpresaCHI = idEmpresaCHI;
    }

    public int getIdEmpresaCHI() {
        return idEmpresaCHI;
    }

    public void setIdEmpresaEXT(int idEmpresaEXT) {
        this.idEmpresaEXT = idEmpresaEXT;
    }

    public int getIdEmpresaEXT() {
        return idEmpresaEXT;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }
}

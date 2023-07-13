package models;

import javax.persistence.*;
import io.ebean.*;

@Entity
public class Oferta extends Model{

    @Id
    public int id;
    public int idEmpresaCHI;
    public int idEmpresaEXT;
    @Column(columnDefinition = "TEXT")
    public String detalle;

    public static final Finder<Long, Oferta> find = new Finder<>(Oferta.class);
}

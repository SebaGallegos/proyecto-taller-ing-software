package models;

import javax.persistence.*;
import io.ebean.*;

@Entity
public class User extends Model{

    @Id
    public int id;
    public String email;
    public String password;

    public static final Finder<Long, User> find = new Finder<>(User.class);
}
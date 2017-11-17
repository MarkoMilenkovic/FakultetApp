package domen;

import domen.Ispit;
import domen.Ispitnirok;
import domen.PolaganjePK;
import domen.Student;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T00:09:33")
@StaticMetamodel(Polaganje.class)
public class Polaganje_ { 

    public static volatile SingularAttribute<Polaganje, Date> datum;
    public static volatile SingularAttribute<Polaganje, Ispitnirok> ispitnirok;
    public static volatile SingularAttribute<Polaganje, Student> student;
    public static volatile SingularAttribute<Polaganje, PolaganjePK> polaganjePK;
    public static volatile SingularAttribute<Polaganje, Ispit> ispit;
    public static volatile SingularAttribute<Polaganje, Integer> ocena;

}
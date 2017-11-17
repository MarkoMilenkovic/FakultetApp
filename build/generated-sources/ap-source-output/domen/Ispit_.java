package domen;

import domen.Polaganje;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T00:09:33")
@StaticMetamodel(Ispit.class)
public class Ispit_ { 

    public static volatile SingularAttribute<Ispit, Integer> sifraIspita;
    public static volatile SingularAttribute<Ispit, String> nazivIspita;
    public static volatile ListAttribute<Ispit, Polaganje> polaganjeList;

}
package domen;

import domen.Mesto;
import domen.Polaganje;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T00:09:33")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> ime;
    public static volatile SingularAttribute<Student, String> prezime;
    public static volatile SingularAttribute<Student, Mesto> ptt;
    public static volatile SingularAttribute<Student, String> brInd;
    public static volatile ListAttribute<Student, Polaganje> polaganjeList;

}
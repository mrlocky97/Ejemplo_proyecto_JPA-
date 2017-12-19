package cursoj.datos.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-11-23T19:35:02.823+0100")
@StaticMetamodel(Persona.class)
public class Persona_ {
	public static volatile SingularAttribute<Persona, Integer> id;
	public static volatile SingularAttribute<Persona, String> name;
	public static volatile SingularAttribute<Persona, String> grupo;
	public static volatile SingularAttribute<Persona, BigDecimal> sueldo;
}

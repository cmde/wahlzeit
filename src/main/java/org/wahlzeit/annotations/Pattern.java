
package org.wahlzeit.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //ElementType.TYPE is for Classes, Interfaces or Enums
@Inherited
public @interface Pattern {
	String name();
	String[] participants();
}

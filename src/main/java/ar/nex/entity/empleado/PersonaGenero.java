package ar.nex.entity.empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Renzo
 */
public enum PersonaGenero {

    MASCULINO(0, "Masculino"),
    FEMENINO(1, "Femenino"),
    OTRO(2, "Otro");

    private final int id;
    private final String value;

    private PersonaGenero(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getValue() {
        return id;
    }

    public String getNombre() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }

    public static Stream<PersonaGenero> stream() {
        return Stream.of(PersonaGenero.values()); 
    }

    @JsonCreator
	public PersonaGenero decode(final String values) {		
        return Stream.of(PersonaGenero.values()).filter(target -> target.value.equals(value)).findFirst().orElse(null);
	}
	
	@JsonValue
	public String getCode() {
		return value;
	}
}
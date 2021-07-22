package ar.nex.entity.empleado;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Renzo
 */
public enum EstadoCivil {

    SOLTERO(0, "Soltero"),
    CASADO(1, "Casado"),
    DIVORCIADO(2, "Divorciado"),
    VIUDO(3, "Viudo"),
    CONCUBINATO(4, "Concubinato"),
    OTRO(9, "Otro");

    private final int id;
    private final String value;

    private EstadoCivil(int id, String value) {
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

    public static Stream<EstadoCivil> stream() {
        return Stream.of(EstadoCivil.values()); 
    }

    @JsonCreator
	public EstadoCivil decode(final String ids) {		
        return Stream.of(EstadoCivil.values()).filter(target -> target.value.equals(value)).findFirst().orElse(null);
	}
	
	@JsonValue
	public String getCode() {
		return value;
	}
}
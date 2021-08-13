package ar.nex.entity.empleado;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Renzo O. Gorosito
 */
public enum PersonaEstado {

    ACTIVO(0, "Activo"), BAJA(1, "Baja"), OTRO(2, "Otro");

    private final int id;
    private final String value;

    private PersonaEstado(int id, String value) {
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

    public static Stream<PersonaEstado> stream() {
        return Stream.of(PersonaEstado.values());
    }

    @JsonCreator
    public PersonaEstado decode(final String values) {
        return Stream.of(PersonaEstado.values()).filter(target -> target.value.equals(value)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return value;
    }

}

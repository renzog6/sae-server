package ar.nex.entity.empleado;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * @author Renzo O. Gorosito
 */
@Entity
@Table(name = "rh_vacacion")
public class Vacacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_vacacion")
	private Long idVacacion;

	@Column(name = "fecha")
	private Date fecha;

	// @Column(name = "empleado")
	@JsonBackReference
	@JoinColumn(name = "empleado", referencedColumnName = "id_persona")
	@ManyToOne
	private Empleado empleado;

	@Column(name = "detalle")
	private String detalle;
	@Column(name = "dias")
	private int dias;
	@Column(name = "anio")
	private int anio;
	@Column(name = "fecha_toma")
	private Date fecha_toma;
	@Column(name = "fecha_liquida")
	private Date fecha_liquida;
	@Column(name = "info")
	private String info;
	@Column(name = "created")
	private Date created;
	@Column(name = "updated")
	private Date updated;

	public Long getIdVacacion() {
		return this.idVacacion;
	}

	public void setIdVacacion(Long idVacacion) {
		this.idVacacion = idVacacion;
	}

	public Vacacion() {
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Date getFechaToma() {
		return fecha_toma;
	}

	public void setFechaToma(Date fecha_toma) {
		this.fecha_toma = fecha_toma;
	}

	public Date getFechaLiquida() {
		return fecha_liquida;
	}

	public void setFechaLiquida(Date fecha_liquida) {
		this.fecha_liquida = fecha_liquida;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((detalle == null) ? 0 : detalle.hashCode());
		result = prime * result + dias;
		result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((fecha_liquida == null) ? 0 : fecha_liquida.hashCode());
		result = prime * result + ((fecha_toma == null) ? 0 : fecha_toma.hashCode());
		result = prime * result + ((idVacacion == null) ? 0 : idVacacion.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacacion other = (Vacacion) obj;
		if (anio != other.anio)
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (detalle == null) {
			if (other.detalle != null)
				return false;
		} else if (!detalle.equals(other.detalle))
			return false;
		if (dias != other.dias)
			return false;
		if (empleado == null) {
			if (other.empleado != null)
				return false;
		} else if (!empleado.equals(other.empleado))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (fecha_liquida == null) {
			if (other.fecha_liquida != null)
				return false;
		} else if (!fecha_liquida.equals(other.fecha_liquida))
			return false;
		if (fecha_toma == null) {
			if (other.fecha_toma != null)
				return false;
		} else if (!fecha_toma.equals(other.fecha_toma))
			return false;
		if (idVacacion == null) {
			if (other.idVacacion != null)
				return false;
		} else if (!idVacacion.equals(other.idVacacion))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vacacion [anio=" + anio + ", created=" + created + ", detalle=" + detalle + ", dias=" + dias
				+ ", empleado=" + empleado + ", fecha=" + fecha + ", fecha_liquida=" + fecha_liquida + ", fecha_toma="
				+ fecha_toma + ", idVacacion=" + idVacacion + ", info=" + info + ", updated=" + updated + "]";
	}

}

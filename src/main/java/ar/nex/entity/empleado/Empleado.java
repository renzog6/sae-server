package ar.nex.entity.empleado;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.nex.entity.Seguro;
import ar.nex.entity.empresa.Empresa;

/**
 *
 * @author Renzo O. Gorosito
 */
@Entity
@Table(name = "rh_empleado")
public class Empleado extends Persona {

    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;

    @JoinColumn(name = "categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private EmpleadoCategoria categoria;

    @JoinColumn(name = "puesto", referencedColumnName = "id_puesto")
    @ManyToOne
    private EmpleadoPuesto puesto;

    @JsonIgnore
    @JoinColumn(name = "empresa", referencedColumnName = "id_empresa")
    @ManyToOne
    private Empresa empresa;

    @JsonIgnore
    @JoinColumn(name = "seguro", referencedColumnName = "id_seguro")
    @ManyToOne
    private Seguro seguro;

    @JsonIgnore
    // @JsonManagedReference
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Vacacion> vacaciones;

    public Empleado() {
        super();
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public EmpleadoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(EmpleadoCategoria categoria) {
        this.categoria = categoria;
    }

    public EmpleadoPuesto getPuesto() {
        return puesto;
    }

    public void setPuesto(EmpleadoPuesto puesto) {
        this.puesto = puesto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public List<Vacacion> getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(List<Vacacion> vacaciones) {
        this.vacaciones = vacaciones;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.fechaAlta);
        hash = 97 * hash + Objects.hashCode(this.fechaBaja);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.fechaAlta, other.fechaAlta)) {
            return false;
        }
        if (!Objects.equals(this.fechaBaja, other.fechaBaja)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getApellido() + " - " + this.puesto.toString();
    }

}

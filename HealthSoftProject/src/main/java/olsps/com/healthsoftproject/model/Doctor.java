/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olsps.com.healthsoftproject.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eusuph
 */
@Entity
@Table(name = "DOCTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByDoctorid", query = "SELECT d FROM Doctor d WHERE d.doctorid = :doctorid"),
    @NamedQuery(name = "Doctor.findByName", query = "SELECT d FROM Doctor d WHERE d.name = :name"),
    @NamedQuery(name = "Doctor.findByDob", query = "SELECT d FROM Doctor d WHERE d.dob = :dob"),
    @NamedQuery(name = "Doctor.findByAddress", query = "SELECT d FROM Doctor d WHERE d.address = :address"),
    @NamedQuery(name = "Doctor.findByPhoneno", query = "SELECT d FROM Doctor d WHERE d.phoneno = :phoneno"),
    @NamedQuery(name = "Doctor.findBySalary", query = "SELECT d FROM Doctor d WHERE d.salary = :salary"),
    @NamedQuery(name = "Doctor.findBySpecialisation", query = "SELECT d FROM Doctor d WHERE d.specialisation = :specialisation")})
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue
    @Column(name = "DOCTORID")
    private Integer doctorid;
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 20)
    @Column(name = "PHONENO")
    private String phoneno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private BigDecimal salary;
    @Size(max = 30)
    @Column(name = "SPECIALISATION")
    private String specialisation;
    @OneToMany(mappedBy = "doctorid", fetch = FetchType.LAZY)
    private Collection<Appointment> appointmentCollection;

    public Doctor() {
    }

    public Doctor(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorid != null ? doctorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.doctorid == null && other.doctorid != null) || (this.doctorid != null && !this.doctorid.equals(other.doctorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "olsps.com.healthsoftproject.model.Doctor[ doctorid=" + doctorid + " ]";
    }
    
}

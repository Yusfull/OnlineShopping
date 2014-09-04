/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olsps.com.healthsoftproject.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "PATIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByPatientno", query = "SELECT p FROM Patient p WHERE p.patientno = :patientno"),
    @NamedQuery(name = "Patient.findByName", query = "SELECT p FROM Patient p WHERE p.name = :name"),
    @NamedQuery(name = "Patient.findByAddress", query = "SELECT p FROM Patient p WHERE p.address = :address"),
    @NamedQuery(name = "Patient.findByPhoneno", query = "SELECT p FROM Patient p WHERE p.phoneno = :phoneno"),
    @NamedQuery(name = "Patient.findByDob", query = "SELECT p FROM Patient p WHERE p.dob = :dob")})
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue
    @Column(name = "PATIENTNO")
    private Integer patientno;
    @Size(max = 40)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 20)
    @Column(name = "PHONENO")
    private String phoneno;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @OneToMany(mappedBy = "patientno", fetch = FetchType.LAZY)
    private Collection<Appointment> appointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientno", fetch = FetchType.LAZY)
    private Collection<Payment> paymentCollection;

    public Patient() {
    }

    public Patient(Integer patientno) {
        this.patientno = patientno;
    }

    
    public Integer getPatientno() {
        return patientno;
    }

    public void setPatientno(Integer patientno) {
        this.patientno = patientno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientno != null ? patientno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patientno == null && other.patientno != null) || (this.patientno != null && !this.patientno.equals(other.patientno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "olsps.com.healthsoftproject.model.Patient[ patientno=" + patientno + " ]";
    }
    
}

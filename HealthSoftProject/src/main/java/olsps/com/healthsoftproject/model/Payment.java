/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olsps.com.healthsoftproject.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eusuph
 */
@Entity
@Table(name = "PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentno", query = "SELECT p FROM Payment p WHERE p.paymentno = :paymentno"),
    @NamedQuery(name = "Payment.findByDetails", query = "SELECT p FROM Payment p WHERE p.details = :details"),
    @NamedQuery(name = "Payment.findByMethod", query = "SELECT p FROM Payment p WHERE p.method = :method")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue
    @Column(name = "PAYMENTNO")
    private Integer paymentno;
    @Size(max = 60)
    @Column(name = "DETAILS")
    private String details;
    @Size(max = 20)
    @Column(name = "METHOD")
    private String method;
    @JoinColumn(name = "PATIENTNO", referencedColumnName = "PATIENTNO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Patient patientno;

    public Payment() {
    }

    public Payment(Integer paymentno) {
        this.paymentno = paymentno;
    }

    public Integer getPaymentno() {
        return paymentno;
    }

    public void setPaymentno(Integer paymentno) {
        this.paymentno = paymentno;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Patient getPatientno() {
        return patientno;
    }

    public void setPatientno(Patient patientno) {
        this.patientno = patientno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentno != null ? paymentno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentno == null && other.paymentno != null) || (this.paymentno != null && !this.paymentno.equals(other.paymentno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "olsps.com.healthsoftproject.model.Payment[ paymentno=" + paymentno + " ]";
    }
    
}

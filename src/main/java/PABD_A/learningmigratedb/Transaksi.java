/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PABD_A.learningmigratedb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "transaksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaksi.findAll", query = "SELECT t FROM Transaksi t"),
    @NamedQuery(name = "Transaksi.findByIdTransaksi", query = "SELECT t FROM Transaksi t WHERE t.idTransaksi = :idTransaksi"),
    @NamedQuery(name = "Transaksi.findByIdBarang", query = "SELECT t FROM Transaksi t WHERE t.idBarang = :idBarang"),
    @NamedQuery(name = "Transaksi.findByIdPembeli", query = "SELECT t FROM Transaksi t WHERE t.idPembeli = :idPembeli"),
    @NamedQuery(name = "Transaksi.findByIdPenjual", query = "SELECT t FROM Transaksi t WHERE t.idPenjual = :idPenjual"),
    @NamedQuery(name = "Transaksi.findByTanggal", query = "SELECT t FROM Transaksi t WHERE t.tanggal = :tanggal"),
    @NamedQuery(name = "Transaksi.findByJenisTransaksi", query = "SELECT t FROM Transaksi t WHERE t.jenisTransaksi = :jenisTransaksi")})
public class Transaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Transaksi")
    private Integer idTransaksi;
    @Basic(optional = false)
    @Column(name = "Id_Barang")
    private int idBarang;
    @Basic(optional = false)
    @Column(name = "Id_Pembeli")
    private int idPembeli;
    @Basic(optional = false)
    @Column(name = "Id_Penjual")
    private int idPenjual;
    @Basic(optional = false)
    @Column(name = "Tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Basic(optional = false)
    @Column(name = "Jenis_Transaksi")
    private String jenisTransaksi;

    public Transaksi() {
    }

    public Transaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Transaksi(Integer idTransaksi, int idBarang, int idPembeli, int idPenjual, Date tanggal, String jenisTransaksi) {
        this.idTransaksi = idTransaksi;
        this.idBarang = idBarang;
        this.idPembeli = idPembeli;
        this.idPenjual = idPenjual;
        this.tanggal = tanggal;
        this.jenisTransaksi = jenisTransaksi;
    }

    public Integer getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public int getIdPembeli() {
        return idPembeli;
    }

    public void setIdPembeli(int idPembeli) {
        this.idPembeli = idPembeli;
    }

    public int getIdPenjual() {
        return idPenjual;
    }

    public void setIdPenjual(int idPenjual) {
        this.idPenjual = idPenjual;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaksi != null ? idTransaksi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaksi)) {
            return false;
        }
        Transaksi other = (Transaksi) object;
        if ((this.idTransaksi == null && other.idTransaksi != null) || (this.idTransaksi != null && !this.idTransaksi.equals(other.idTransaksi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PABD_A.learningmigratedb.Transaksi[ idTransaksi=" + idTransaksi + " ]";
    }
    
}

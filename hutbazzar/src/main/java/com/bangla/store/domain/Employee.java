 
package com.bangla.store.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer id;

    @NotNull(message = "Name should not blank")
    @Column(name = "EmployeeName")
    private String employeeName;

    @NotNull(message = "Email should not blank")
    @Email(message = "Email should be valid")
    @Column(name = "EmployeeEmail")
    private String employeeEmail;

    @NotNull(message = "Mobile should not blank")
    @Column(name = "EmployeeMobile")
    private String employeeMobile;

    @Column(name = "Picture")
    private String picture;

    @Column(name = "NID")
    private long nid;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getOfficeStart() {
        return OfficeStart;
    }

    public void setOfficeStart(Date OfficeStart) {
        this.OfficeStart = OfficeStart;
    }

    public Date getOfficeEnd() {
        return OfficeEnd;
    }

    public void setOfficeEnd(Date OfficeEnd) {
        this.OfficeEnd = OfficeEnd;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public int getcLObtain() {
        return cLObtain;
    }

    public void setcLObtain(int cLObtain) {
        this.cLObtain = cLObtain;
    }

    public int getcLSpent() {
        return cLSpent;
    }

    public void setcLSpent(int cLSpent) {
        this.cLSpent = cLSpent;
    }

    public int getmLObtain() {
        return mLObtain;
    }

    public void setmLObtain(int mLObtain) {
        this.mLObtain = mLObtain;
    }

    public int getmLSpent() {
        return mLSpent;
    }

    public void setmLSpent(int mLSpent) {
        this.mLSpent = mLSpent;
    }

    public int geteLObtain() {
        return eLObtain;
    }

    public void seteLObtain(int eLObtain) {
        this.eLObtain = eLObtain;
    }

    public int geteLSpent() {
        return eLSpent;
    }

    public void seteLSpent(int eLSpent) {
        this.eLSpent = eLSpent;
    }
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "DateOfBirth", nullable = true)
    private Date dateOfBirth;
    @NotNull
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Temporal(TemporalType.TIME)
    @Column(name = "OfficeStart", nullable = true)
    private Date OfficeStart;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Temporal(TemporalType.TIME)
    @Column(name = "OfficeEnd", nullable = true)
    private Date OfficeEnd;
    
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "EffectDate", nullable = true)
    private Date effectDate;

    @Column(name = "PresentAddress")
    private String presentAddress;

    @Column(name = "PermanentAddress")
    private String permanentAddress;

    @Column(name = "FatherName")
    private String fatherName;

    @Column(name = "MotherName")
    private String motherName;

    @Column(name = "BloodGroup", nullable = true)
    private String bloodGroup;

    @Column(name = "EmergencyContact")
    private String emergencyContact;

    @Column(name = "EmployeeTelExt")
    private String employeeTelExt;

    @Column(name = "EmployeeDistrictId")
    private int employeeDistrictId;

    @Column(name = "EmployeeAreaId")
    private int employeeAreaId;

    @Column(name = "EmployeeDesignationId")
    private int employeeDesignationId;

    @Column(name = "EmployeeUserName")
    private String employeeUserName;

    @Column(name = "EmployeeUserPassword")
    private String employeeUserPassword;

    @Column(name = "EmployeeDepartmentId")
    private short employeeDepartmentId;

    @Column(name = "EmployeeGroupId")
    private short employeeGroupId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "EmployeeTotalSalary")
    private BigDecimal employeeTotalSalary;

    @Column(name = "EmployeeStatus")
    private short employeeStatus;

    @Column(name = "EmployeeRemarks")
    private String employeeRemarks;

    @Column(name = "DhakacomId")
    private long dhakacomId;

    @Column(name = "ShiftingId")
    private int shiftingId;

    @Column(name = "CLObtain")
    private int cLObtain;

    @Column(name = "CLSpent")
    private int cLSpent;

    @Column(name = "MLObtain")
    private int mLObtain;

    @Column(name = "MLSpent")
    private int mLSpent;

    @Column(name = "ELObtain")
    private int eLObtain;

    @Column(name = "ELSpent")
    private int eLSpent;

    @Column(name = "EmployeeCurrentStatus")
    private short employeeCurrentStatus;

    @Column(name = "Reason")
    private String reason;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String employeeName, String employeeEmail, String employeeMobile, String picture, long nid, String presentAddress, String permanentAddress, String fatherName, String motherName, String bloodGroup, Date dateOfBirth, String emergencyContact, String employeeTelExt, int employeeDistrictId, int employeeAreaId, int employeeDesignationId, String employeeUserName, String employeeUserPassword, short employeeDepartmentId, short employeeGroupId, BigDecimal employeeTotalSalary, short employeeStatus, String employeeRemarks, long dhakacomId, int shiftingId, Date officeStart, Date officeEnd, int cLObtain, int cLSpent, int mLObtain, int mLSpent, int eLObtain, int eLSpent, short employeeCurrentStatus, Date effectDate, String reason) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeMobile = employeeMobile;
        this.picture = picture;
        this.nid = nid;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.employeeTelExt = employeeTelExt;
        this.employeeDistrictId = employeeDistrictId;
        this.employeeAreaId = employeeAreaId;
        this.employeeDesignationId = employeeDesignationId;
        this.employeeUserName = employeeUserName;
        this.employeeUserPassword = employeeUserPassword;
        this.employeeDepartmentId = employeeDepartmentId;
        this.employeeGroupId = employeeGroupId;
        this.employeeTotalSalary = employeeTotalSalary;
        this.employeeStatus = employeeStatus;
        this.employeeRemarks = employeeRemarks;
        this.dhakacomId = dhakacomId;
        this.shiftingId = shiftingId;
        this.cLObtain = cLObtain;
        this.cLSpent = cLSpent;
        this.mLObtain = mLObtain;
        this.mLSpent = mLSpent;
        this.eLObtain = eLObtain;
        this.eLSpent = eLSpent;
        this.employeeCurrentStatus = employeeCurrentStatus;
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(String employeeMobile) {
        this.employeeMobile = employeeMobile;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getNid() {
        return nid;
    }

    public void setNid(long nid) {
        this.nid = nid;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmployeeTelExt() {
        return employeeTelExt;
    }

    public void setEmployeeTelExt(String employeeTelExt) {
        this.employeeTelExt = employeeTelExt;
    }

    public int getEmployeeDistrictId() {
        return employeeDistrictId;
    }

    public void setEmployeeDistrictId(int employeeDistrictId) {
        this.employeeDistrictId = employeeDistrictId;
    }

    public int getEmployeeAreaId() {
        return employeeAreaId;
    }

    public void setEmployeeAreaId(int employeeAreaId) {
        this.employeeAreaId = employeeAreaId;
    }

    public int getEmployeeDesignationId() {
        return employeeDesignationId;
    }

    public void setEmployeeDesignationId(int employeeDesignationId) {
        this.employeeDesignationId = employeeDesignationId;
    }

    public String getEmployeeUserName() {
        return employeeUserName;
    }

    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    public String getEmployeeUserPassword() {
        return employeeUserPassword;
    }

    public void setEmployeeUserPassword(String employeeUserPassword) {
        this.employeeUserPassword = employeeUserPassword;
    }

    public short getEmployeeDepartmentId() {
        return employeeDepartmentId;
    }

    public void setEmployeeDepartmentId(short employeeDepartmentId) {
        this.employeeDepartmentId = employeeDepartmentId;
    }

    public short getEmployeeGroupId() {
        return employeeGroupId;
    }

    public void setEmployeeGroupId(short employeeGroupId) {
        this.employeeGroupId = employeeGroupId;
    }

    public BigDecimal getEmployeeTotalSalary() {
        return employeeTotalSalary;
    }

    public void setEmployeeTotalSalary(BigDecimal employeeTotalSalary) {
        this.employeeTotalSalary = employeeTotalSalary;
    }

    public short getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(short employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeRemarks() {
        return employeeRemarks;
    }

    public void setEmployeeRemarks(String employeeRemarks) {
        this.employeeRemarks = employeeRemarks;
    }

    public long getDhakacomId() {
        return dhakacomId;
    }

    public void setDhakacomId(long dhakacomId) {
        this.dhakacomId = dhakacomId;
    }

    public int getShiftingId() {
        return shiftingId;
    }

    public void setShiftingId(int shiftingId) {
        this.shiftingId = shiftingId;
    }

    public int getCLObtain() {
        return cLObtain;
    }

    public void setCLObtain(int cLObtain) {
        this.cLObtain = cLObtain;
    }

    public int getCLSpent() {
        return cLSpent;
    }

    public void setCLSpent(int cLSpent) {
        this.cLSpent = cLSpent;
    }

    public int getMLObtain() {
        return mLObtain;
    }

    public void setMLObtain(int mLObtain) {
        this.mLObtain = mLObtain;
    }

    public int getMLSpent() {
        return mLSpent;
    }

    public void setMLSpent(int mLSpent) {
        this.mLSpent = mLSpent;
    }

    public int getELObtain() {
        return eLObtain;
    }

    public void setELObtain(int eLObtain) {
        this.eLObtain = eLObtain;
    }

    public int getELSpent() {
        return eLSpent;
    }

    public void setELSpent(int eLSpent) {
        this.eLSpent = eLSpent;
    }

    public short getEmployeeCurrentStatus() {
        return employeeCurrentStatus;
    }

    public void setEmployeeCurrentStatus(short employeeCurrentStatus) {
        this.employeeCurrentStatus = employeeCurrentStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bangla.store.domain.Employees[ id=" + id + " ]";
    }

}

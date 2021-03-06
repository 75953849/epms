package com.tyut.epms.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Subatt {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subatt.id
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subatt.emp_id
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    private Long empId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subatt.emp_name
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    private String empName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subatt.att_date
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date attDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subatt.att_state
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    private String attState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subatt.id
     *
     * @return the value of subatt.id
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subatt.id
     *
     * @param id the value for subatt.id
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subatt.emp_id
     *
     * @return the value of subatt.emp_id
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subatt.emp_id
     *
     * @param empId the value for subatt.emp_id
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subatt.emp_name
     *
     * @return the value of subatt.emp_name
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subatt.emp_name
     *
     * @param empName the value for subatt.emp_name
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subatt.att_date
     *
     * @return the value of subatt.att_date
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public Date getAttDate() {
        return attDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subatt.att_date
     *
     * @param attDate the value for subatt.att_date
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public void setAttDate(Date attDate) {
        this.attDate = attDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subatt.att_state
     *
     * @return the value of subatt.att_state
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public String getAttState() {
        return attState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subatt.att_state
     *
     * @param attState the value for subatt.att_state
     *
     * @mbg.generated Fri Mar 27 10:17:42 CST 2020
     */
    public void setAttState(String attState) {
        this.attState = attState == null ? null : attState.trim();
    }
}
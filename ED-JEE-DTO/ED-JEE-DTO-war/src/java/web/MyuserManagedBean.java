/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web;

import entity.MyuserDTO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import session.MyuserFacadeRemote;

/**
 *
 * @author Henry Ennis-Thomas
 */
@Named(value = "myuserManagedBean")
@RequestScoped
public class MyuserManagedBean {

    @javax.ejb.EJB
    private MyuserFacadeRemote myuserFacade;

    public MyuserFacadeRemote getMyuserFacade() {
        return myuserFacade;
    }

    public void setMyuserFacade(MyuserFacadeRemote myuserFacade) {
        this.myuserFacade = myuserFacade;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSecQn() {
        return secQn;
    }

    public void setSecQn(String secQn) {
        this.secQn = secQn;
    }

    public String getSecAns() {
        return secAns;
    }

    public void setSecAns(String secAns) {
        this.secAns = secAns;
    }

    private String userid;
    private String name;
    private String password;
    private String cPassword; // for confirmed password field
    private String email;
    private String phone;
    private String address;
    private String secQn;
    private String secAns;

    /**
     * Creates a new instance of MyuserManagedBean
     */
    public MyuserManagedBean() {
    }

    public String addUser() {
        String result = "failure";
        /*
* are all data entered valid?
* and password the same as cPassword (case sensitive)
* before calling the façade’s createRecord() method
         */
        if (isValidUserid(userid) && isValidName(name)
                && isValidPassword(password) && isValidPassword(cPassword)
                && isValidEmail(email) && isValidPhone(phone)
                && isValidAddress(address) && isValidSecQn(secQn)
                && isValidSecAns(secAns) && password.equals(cPassword)) {

            MyuserDTO myuserDTO = new MyuserDTO(userid, name,
                    password, email, phone, address, secQn, secAns);

            if (myuserFacade.createRecord(myuserDTO)) {
                result = "success";
            } else {
                result = "failure";
            }

        }
        return result;
    }

    public String findUser() {
        String result = "failure";
        if (isValidUserid(userid)) {
            MyuserDTO res = myuserFacade.getRecord(userid);
            if (res != null) {
                setUserid(res.getUserid());
                setName(res.getName());
                setPassword(res.getPassword());
                setEmail(res.getEmail());
                setPhone(res.getPhone());
                setAddress(res.getAddress());
                setSecQn(res.getSecQn());
                setSecAns(res.getSecAns());
                result = "success";
            }
        }
        return result;
    }

    public String updateUser() {
        String result = "failure";
        if (isValidName(name)
                && isValidPassword(password) && isValidPassword(cPassword)
                && isValidEmail(email) && isValidPhone(phone)
                && isValidAddress(address) && isValidSecQn(secQn)
                && isValidSecAns(secAns) && password.equals(cPassword)) {

            MyuserDTO myuserDTO = new MyuserDTO(getUserid(), name,
                    password, email, phone, address, secQn, secAns);

            if (myuserFacade.updateRecord(myuserDTO)) {

                result = "success";

            } else {
                result = "failure";
            }

        }
        return result;
    }

    /* Some basic checking, complicated checking can be done later
* not a good way of doing this
* Should use JSF’s validator method to do this – left as C task
     */
    public boolean isValidUserid(String userid) {
        return (userid != null);
    }

    public boolean isValidName(String name) {
        return (name != null);
    }

    public boolean isValidPassword(String password) {
        return (password != null);
    }

    public boolean isValidEmail(String email) {
        return (email != null);
    }

    public boolean isValidPhone(String phone) {
        return (phone != null);
    }

    public boolean isValidAddress(String address) {
        return (address != null);
    }

    public boolean isValidSecQn(String secQn) {
        return (secQn != null);
    }

    public boolean isValidSecAns(String secAns) {
        return (secAns != null);
    }

}

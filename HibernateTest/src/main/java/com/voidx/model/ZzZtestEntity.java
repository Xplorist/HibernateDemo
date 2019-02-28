package com.voidx.model;

@javax.persistence.Entity
@javax.persistence.Table(name = "ZZ_ZTEST", schema = "EPDM1", catalog = "")
public class ZzZtestEntity {
    private String accountName;
    private String personName;

    @javax.persistence.Id
    @javax.persistence.Column(name = "ACCOUNT_NAME", nullable = false, length = 255)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "PERSON_NAME", nullable = true, length = 255)
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

}

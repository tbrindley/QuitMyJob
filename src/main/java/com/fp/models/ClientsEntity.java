package com.fp.models;

import javax.persistence.*;

/**
 * Created by jayme on 8/8/2017.
 */
@Entity
@Table(name = "clients", schema = "quitmyjob", catalog = "")
public class ClientsEntity {
    private int clientId;
    private String email;
    private String password;
    private String job;
    private String finId;

    @Id
    @Column(name = "client_id", nullable = false)
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "job", nullable = true, length = 45)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "fin_id", nullable = true, length = 45)
    public String getFinId() {
        return finId;
    }

    public void setFinId(String finId) {
        this.finId = finId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (clientId != that.clientId) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (job != null ? !job.equals(that.job) : that.job != null) return false;
        if (finId != null ? !finId.equals(that.finId) : that.finId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (finId != null ? finId.hashCode() : 0);
        return result;
    }
}

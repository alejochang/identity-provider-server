package com.alejochang.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by achang on 6/24/16.
 */
@Entity
public class AuthToken {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;
    @JsonProperty("key")
    private String key;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("creation_date")
    private Date creationDate;


    public AuthToken(String username, String key){
        this.username = username;
        this.key = key;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthToken authToken = (AuthToken) o;

        if (id != null ? !id.equals(authToken.id) : authToken.id != null) return false;
        if (username != null ? !username.equals(authToken.username) : authToken.username != null) return false;
        if (key != null ? !key.equals(authToken.key) : authToken.key != null) return false;
        return creationDate != null ? creationDate.equals(authToken.creationDate) : authToken.creationDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthToken{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", key='" + key + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}

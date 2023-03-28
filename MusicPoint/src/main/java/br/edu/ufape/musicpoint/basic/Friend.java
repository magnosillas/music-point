package br.edu.ufape.musicpoint.basic;

import jakarta.persistence.Id;

public class Friend {
    @Id
    private Long idAccount;
    private String username;

    public Friend() {
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

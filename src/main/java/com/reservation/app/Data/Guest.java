package com.reservation.app.Data;
import jakarta.persistence.*;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String password;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    // Constructors, getters, setters, and toString

    public Guest() {}

    public Guest(String email, String name, String password, Table table) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.table = table;
    }

    // Other getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }


}

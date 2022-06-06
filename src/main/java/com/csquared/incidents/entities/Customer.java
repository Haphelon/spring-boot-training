package com.csquared.incidents.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age_group")
    private Integer ageGroup;

    @Column(name = "send_updates")
    private Boolean sendUpdates;

    public boolean isMale(){
        return Objects.equals(this.sex, 0);
    }

    public boolean isFemale(){
        return Objects.equals(this.sex, 1);
    }

}

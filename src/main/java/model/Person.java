
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Id;

public class Person {
    
    @JsonIgnore
    protected String _id;
    @JsonProperty("name")
    protected String name;
    @JsonProperty("lastname")
    protected String lastname;
    @JsonProperty("age")
    protected int age;
    @JsonProperty("email")
    protected String email;
    @JsonProperty("phone")
    protected int phone;

    public Person() {
    }

    public Person(String name, String lastname, int age, String email, int phone) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
   
    
    
}

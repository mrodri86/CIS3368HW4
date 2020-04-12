package com.hearthstone.Homework4.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "love")
public class Love {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "sname")
    private String sname;
    @Column(name = "percentage")
    private String percentage;
    @Column(name = "result")
    private String result;

    public Love()
    {

    }
    public Love(String id, String fname, String sname, String percentage, String result){
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.percentage = percentage;
        this.result = result;
    }

    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getFname(){return fname;}
    public void setFname(String fname){this.fname=fname;}
    public String getSname(){return sname;}
    public void setSname(String sname){this.sname=sname;}
    public String getPercentage(){return percentage;}
    public void setPercentage(String percentage){this.percentage=percentage;}
    public String getResult(){return result;}
    public void setResult(String result){this.result=result;}
}

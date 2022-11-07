package com.cms.entity;


import java.util.Date;


public class S_SupplyModel {
    private int supply_id;
    private String supply_name;
    private String supply_brand;
    private String supply_type;
    private String supply_uom;
    private String unit_price;
    private Date date;
    private String status;

    public int getSupply_id() {
        return supply_id;
    }

    public void setSupply_id(int supply_id) {
        this.supply_id = supply_id;
    }

    public String getSupply_name() {
        return supply_name;
    }

    public void setSupply_name(String supply_name) {
        this.supply_name = supply_name;
    }

    public String getSupply_brand() {
        return supply_brand;
    }

    public void setSupply_brand(String supply_brand) {
        this.supply_brand = supply_brand;
    }

    public String getSupply_type() {
        return supply_type;
    }

    public void setSupply_type(String supply_type) {
        this.supply_type = supply_type;
    }

    public String getSupply_uom() {
        return supply_uom;
    }

    public void setSupply_uom(String supply_uom) {
        this.supply_uom = supply_uom;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

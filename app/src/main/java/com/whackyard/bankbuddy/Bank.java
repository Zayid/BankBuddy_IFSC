package com.whackyard.bankbuddy;

/**
 * Created by Nazila on 14/12/2016.
 */

public class Bank {

    int _id;
    String _bank;
    String _state;
    String _micr;
    String _branch;
    String _contact;
    String _address;
    String _city;
    String _district;
    String _ifsc;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_bank() {
        return _bank;
    }

    public void set_bank(String _bank) {
        this._bank = _bank;
    }

    public String get_state() {
        return _state;
    }

    public void set_state(String _state) {
        this._state = _state;
    }

    public String get_micr() {
        return _micr;
    }

    public void set_micr(String _micr) {
        this._micr = _micr;
    }

    public String get_branch() {
        return _branch;
    }

    public void set_branch(String _branch) {
        this._branch = _branch;
    }

    public String get_contact() {
        return _contact;
    }

    public void set_contact(String _contact) {
        this._contact = _contact;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_district() {
        return _district;
    }

    public void set_district(String _district) {
        this._district = _district;
    }

    public String get_ifsc() {
        return _ifsc;
    }

    public void set_ifsc(String _ifsc) {
        this._ifsc = _ifsc;
    }

    public Bank(){

    }
    public Bank(int _id, String _bank, String _state, String _micr, String _branch, String _contact, String _address, String _city, String _district, String _ifsc) {
        this._id = _id;
        this._bank = _bank;
        this._state = _state;
        this._micr = _micr;
        this._branch = _branch;
        this._contact = _contact;
        this._address = _address;
        this._city = _city;
        this._district = _district;
        this._ifsc = _ifsc;
    }

    public Bank(String _bank, String _state, String _micr, String _branch, String _contact, String _address, String _city, String _district, String _ifsc) {
        this._bank = _bank;
        this._state = _state;
        this._micr = _micr;
        this._branch = _branch;
        this._contact = _contact;
        this._address = _address;
        this._city = _city;
        this._district = _district;
        this._ifsc = _ifsc;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.sd.servidor;

/**
 *
 * @author Hugo
 */
class Agenda {

    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public Agenda(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Agenda() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

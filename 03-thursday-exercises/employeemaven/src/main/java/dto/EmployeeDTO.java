/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;

/**
 *
 * @author Lukas Bjørnvad
 */
public class EmployeeDTO {
  private long id;
  private String name;
  private String adress;

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
        this.adress = e.getAdress();
    }

}

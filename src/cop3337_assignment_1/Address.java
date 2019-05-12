/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop3337_assignment_1;

/**
 *
 * @author AbsoluteCrow
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipcode;
    
    public void setStreet(String street)
    {
        this.street = street;
    }
    
    public String getStreet()
    {
        return this.street;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getCity()
    {
        return this.city;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public String getState()
    {
        return this.state;
    }
    
    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }
    
    public String getZipcode()
    {
        return this.zipcode;
    }
      
}

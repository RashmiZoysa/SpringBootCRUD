package wixis360.dto;


/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/

public class EmployeeDTO {
    private String id;
    private String name;
    private int contact;
    private String address;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String id, String name, int contact, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }
}

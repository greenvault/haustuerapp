package de.gruene.haustuer.door;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address {
  
  @Max(255)
  private String company;
  @NotNull
  @NotEmpty
  @Size(max = 255)
  private String street;
  @NotNull
  @NotEmpty
  @Size(max = 255)
  private String city;
  @NotNull
  @NotEmpty
  @Size(max = 255)
  private String zip;
  @NotNull
  @NotEmpty
  @Size(max = 255)
  private String country;

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Address address = (Address) o;

    if (company != null ? !company.equals(address.company) : address.company != null) {
      return false;
    }
    if (street != null ? !street.equals(address.street) : address.street != null) {
      return false;
    }
    if (city != null ? !city.equals(address.city) : address.city != null) {
      return false;
    }
    if (zip != null ? !zip.equals(address.zip) : address.zip != null) {
      return false;
    }
    return country != null ? country.equals(address.country) : address.country == null;
  }

  @Override
  public int hashCode() {
    int result = company != null ? company.hashCode() : 0;
    result = 31 * result + (street != null ? street.hashCode() : 0);
    result = 31 * result + (city != null ? city.hashCode() : 0);
    result = 31 * result + (zip != null ? zip.hashCode() : 0);
    result = 31 * result + (country != null ? country.hashCode() : 0);
    return result;
  }
}

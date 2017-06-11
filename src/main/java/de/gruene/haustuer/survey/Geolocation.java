package de.gruene.haustuer.survey;

import javax.persistence.Embeddable;

@Embeddable
public class Geolocation {

  private double longitude;
  private double latitude;

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Geolocation that = (Geolocation) o;

    if (Double.compare(that.longitude, longitude) != 0) {
      return false;
    }
    return Double.compare(that.latitude, latitude) == 0;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(longitude);
    result = (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(latitude);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "Geolocation{" +
        "longitude='" + longitude + '\'' +
        ", latitude='" + latitude + '\'' +
        '}';
  }
}

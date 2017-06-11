package de.gruene.haustuer.survey;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
/**
 * StreetLevelAddress does not store the street number
 */
public class StreetLevelAddress extends Address {

  @Override
  @Transient
  @JsonInclude
  public String getNumber() {
    return super.getNumber();
  }
}

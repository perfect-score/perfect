package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for database table storing countries.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "countries")
public class Country implements Serializable {
   
   private static final long serialVersionUID = 8752285805430000L;

   @Id
   @Column(name = "iso_code", length = 2, nullable = false)
   private String isoCode = "";

   public Country() {}

   public Country(final String isoCode) {
      setIsoCode(isoCode);
   }

   public void setIsoCode(final String isoCode) {
      this.isoCode = isoCode;
   }

   public String getIsoCode() {
      return isoCode;
   }

   /**
    * Display the details.
    * 
    * @return String containing the details loaded.
    */
   public String displayDetails() {
      return "Country " + "[IsoCode=" + getIsoCode() + "]";
   }

   @Override
   public String toString() {
      return displayDetails();
   }

   /**
    * Return a new version of the entity - this may act as an aid to persistence.
    * 
    * @return Entity comprised of data within this entity.
    */
   public Country getEntity() {
      Country country = new Country();

      country.setIsoCode(this.isoCode);

      return country;
   }
}

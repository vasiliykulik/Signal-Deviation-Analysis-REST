package ua.sda.entity.opticalnodeinterface;

import ua.sda.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vasiliy Kylik on 16.07.2017.
 */
@Entity
@Table(name = "modems")
public class Modem extends BaseEntity {

	@Column(name = "street")
	private String street;
	@Column(name = "houseNumber")
	private String houseNumber;
	@Column(name = "linkToMAC")
	private String linkToMAC;


	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "modems_measurements",
			joinColumns = @JoinColumn(name = "modemId"),
			inverseJoinColumns = @JoinColumn(name = "measurementsId")
	)
	private List<Measurement> measurements;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "modems_location",
			joinColumns = @JoinColumn(name = "modemId"),
			inverseJoinColumns = @JoinColumn(name = "locationId")
	)
	private ModemLocation modemLocation;

	public Modem() {
	}

	public Modem(String street, String houseNumber, String linkToMAC, List<Measurement> measurements, ModemLocation modemLocation) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.linkToMAC = linkToMAC;
		this.measurements = measurements;
		this.modemLocation = modemLocation;
	}

	@Override
	public String toString() {
		return "Modem{" +
				"street='" + street + '\'' +
				", houseNumber='" + houseNumber + '\'' +
				", linkToMAC='" + linkToMAC + '\'' +
				", measurements=" + measurements +
				", modemLocation=" + modemLocation +
				'}';
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getLinkToMAC() {
		return linkToMAC;
	}

	public void setLinkToMAC(String linkToMAC) {
		this.linkToMAC = linkToMAC;
	}

	public List<Measurement> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

	public ModemLocation getModemLocation() {
		return modemLocation;
	}

	public void setModemLocation(ModemLocation modemLocation) {
		this.modemLocation = modemLocation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Modem modem = (Modem) o;

		if (street != null ? !street.equals(modem.street) : modem.street != null) return false;
		if (houseNumber != null ? !houseNumber.equals(modem.houseNumber) : modem.houseNumber != null) return false;
		if (linkToMAC != null ? !linkToMAC.equals(modem.linkToMAC) : modem.linkToMAC != null) return false;
		if (measurements != null ? !measurements.equals(modem.measurements) : modem.measurements != null) return false;
		return modemLocation != null ? modemLocation.equals(modem.modemLocation) : modem.modemLocation == null;
	}

	@Override
	public int hashCode() {
		int result = street != null ? street.hashCode() : 0;
		result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
		result = 31 * result + (linkToMAC != null ? linkToMAC.hashCode() : 0);
		result = 31 * result + (measurements != null ? measurements.hashCode() : 0);
		result = 31 * result + (modemLocation != null ? modemLocation.hashCode() : 0);
		return result;
	}
}

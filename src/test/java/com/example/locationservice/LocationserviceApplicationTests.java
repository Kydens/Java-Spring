package com.example.locationservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.locationservice.models.DTO.CountryDTO;
import com.example.locationservice.models.DTO.DepartmentDTO;
import com.example.locationservice.models.DTO.LocationDTO;
import com.example.locationservice.models.DTO.OfficeDTO;
import com.example.locationservice.services.CountryService;
import com.example.locationservice.services.DepartmentService;
import com.example.locationservice.services.LocationService;
import com.example.locationservice.services.OfficeService;

@SpringBootTest
class LocationserviceApplicationTests {
	private final DepartmentService departmentService;
	private final CountryService countryService;
	private final LocationService locationService;
	private final OfficeService officeService;

	@Autowired
	public LocationserviceApplicationTests(DepartmentService departmentService, CountryService countryService, LocationService locationService, OfficeService officeService) {
		this.departmentService = departmentService;
		this.countryService = countryService;
		this.locationService = locationService;
		this.officeService = officeService;
	}

	@Test
	void contextLoads() {
		/*
		 * AAA
		 * A -> Arrange
		 * A -> Act
		 * A -> Assert 
		 */
	}

	@Test
	void insertDepartment() {
		// Arrange
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartmentId(3);
		departmentDTO.setDepartmentName("Operation & Delivery JKT");
		departmentDTO.setOfficeId(1);

		// Action
		Boolean result = departmentService.save(departmentDTO);

		// Assert
		assertEquals(true, result);
	}

	@Test
	void insertCountry() {
		// Arrange
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setCountryId(1);
		countryDTO.setCountryName("Indonesia");
		countryDTO.setCountryCode("ID");
		countryDTO.setRegionId(1);

		// Action
		Boolean result = countryService.save(countryDTO);

		// Assert
		assertEquals(true, result);
	}

	@Test
	void insertLocation() {
		// Arrange
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocationId(1);
		locationDTO.setAddress("Jalan Kuningan City");
		locationDTO.setPostalCode(11111);
		locationDTO.setCity("Jakarta Selatan");
		locationDTO.setProvince("Jakarta");
		locationDTO.setCountryId(1);

		// Action
		Boolean result = locationService.save(locationDTO);

		// Assert
		assertEquals(true, result);
	}

	@Test
	void insertOffice() {
		// Arrange
		OfficeDTO officeDTO = new OfficeDTO();
		officeDTO.setOfficeId(1);
		officeDTO.setOfficeName("Office Center");
		officeDTO.setLocationId(1);

		// Action
		Boolean result = officeService.save(officeDTO);

		// Assert
		assertEquals(true, result);
	}
}

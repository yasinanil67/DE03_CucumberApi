package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactPojo{
	private String firstName;
	private String lastName;
	private String country;
	private String birthdate;
	private String phone;
	private String city;
	private String postalCode;
	private String stateProvince;
	private String street1;
	private String street2;
	private String email;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setBirthdate(String birthdate){
		this.birthdate = birthdate;
	}

	public String getBirthdate(){
		return birthdate;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public void setStateProvince(String stateProvince){
		this.stateProvince = stateProvince;
	}

	public String getStateProvince(){
		return stateProvince;
	}

	public void setStreet1(String street1){
		this.street1 = street1;
	}

	public String getStreet1(){
		return street1;
	}

	public void setStreet2(String street2){
		this.street2 = street2;
	}

	public String getStreet2(){
		return street2;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"ContactPojo{" + 
			"firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",country = '" + country + '\'' + 
			",birthdate = '" + birthdate + '\'' + 
			",phone = '" + phone + '\'' + 
			",city = '" + city + '\'' + 
			",postalCode = '" + postalCode + '\'' + 
			",stateProvince = '" + stateProvince + '\'' + 
			",street1 = '" + street1 + '\'' + 
			",street2 = '" + street2 + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}

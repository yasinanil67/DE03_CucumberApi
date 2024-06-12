package pojos;

public class User{
	private String firstName;
	private String lastName;
	private Integer __v;
	private String _id;
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

	public void set__v(Integer V){
		this.__v = V;
	}

	public Integer get__v(){
		return __v;
	}

	public void set_id(String _id){
		this._id = _id;
	}

	public String get_id(){
		return _id;
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
			"User{" + 
			"firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",__v = '" + __v + '\'' +
			",_id = '" + _id + '\'' +
			",email = '" + email + '\'' + 
			"}";
		}
}

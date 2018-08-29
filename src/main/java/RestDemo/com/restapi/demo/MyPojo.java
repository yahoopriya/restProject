package RestDemo.com.restapi.demo;

public class MyPojo {
	
	    private String id;

	    private String[] cities;

	    private Address address;

	    private String permanent;

	    private String name;

	    private String role;

	    private Properties properties;

	    private String[] phoneNumbers;

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String[] getCities ()
	    {
	        return cities;
	    }

	    public void setCities (String[] cities)
	    {
	        this.cities = cities;
	    }

	    public Address getAddress ()
	    {
	        return address;
	    }

	    public void setAddress (Address address)
	    {
	        this.address = address;
	    }

	    public String getPermanent ()
	    {
	        return permanent;
	    }

	    public void setPermanent (String permanent)
	    {
	        this.permanent = permanent;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String getRole ()
	    {
	        return role;
	    }

	    public void setRole (String role)
	    {
	        this.role = role;
	    }

	    public Properties getProperties ()
	    {
	        return properties;
	    }

	    public void setProperties (Properties properties)
	    {
	        this.properties = properties;
	    }

	    public String[] getPhoneNumbers ()
	    {
	        return phoneNumbers;
	    }

	    public void setPhoneNumbers (String[] phoneNumbers)
	    {
	        this.phoneNumbers = phoneNumbers;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [id = "+id+", cities = "+cities+", address = "+address+", permanent = "+permanent+", name = "+name+", role = "+role+", properties = "+properties+", phoneNumbers = "+phoneNumbers+"]";
	    }
	}



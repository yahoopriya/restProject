package RestDemo.com.restapi.demo;

public class Properties {

	    private String age;

	    private String salary;

	    public String getAge ()
	    {
	        return age;
	    }

	    public void setAge (String age)
	    {
	        this.age = age;
	    }

	    public String getSalary ()
	    {
	        return salary;
	    }

	    public void setSalary (String salary)
	    {
	        this.salary = salary;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [age = "+age+", salary = "+salary+"]";
	    }
	}



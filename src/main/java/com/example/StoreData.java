package com.example;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		SessionFactory str = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = str.openSession();
		try{
			//Step 1 create table and insert query, and comment below code for first run
			/*createTable(session);
			insert(session);*/
			
			//Step 2 just execute select query and comment above code for second run
			List<Employee> select = select(session);
			System.out.println(select);
		}finally{
			session.close();
			str.close();
		}

	}

	private static void createTable(Session session) {
		SQLQuery createSQLQuery = session.createSQLQuery("CREATE TABLE employee(`emp_id` INT(11) AUTO_INCREMENT PRIMARY KEY,`name` VARCHAR(64),`address_fk` INT(11))");
		createSQLQuery.executeUpdate();
		SQLQuery createSQLQuery2 = session.createSQLQuery("CREATE TABLE address(`addr_id` INT(11) AUTO_INCREMENT PRIMARY KEY,`type` VARCHAR(64),`office_address` VARCHAR(256),`home_address` VARCHAR(256))");
		createSQLQuery2.executeUpdate();
	}

	private static List<Employee> select(Session session) {
		Query createQuery = session.createQuery("from com.example.Employee e join fetch e.homeAddress as h where e.empId = 1"); //Error
//		Query createQuery = session.createQuery("from com.example.Employee e where e.empId = 1"); // Works Fine, but getting homeAddress out of session give an exception
		List<Employee> list = createQuery.list();
		return list;
	}

	private static void insert(Session session) {
		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("sonoo");

		OfficeAddress officeAddress = new OfficeAddress();
		officeAddress.setOfficeAddress("This is my office Address");
		
		session.save(officeAddress);
		e1.setAddressFk(officeAddress.getAddressId());
		session.save(e1);
		
		Employee e2 = new Employee();
		e2.setName("sonoo");
		
		HomeAddress homeAddress = new HomeAddress();
		homeAddress.setHomeAddress("This is my Home address");
		session.save(homeAddress);
		e2.setAddressFk(homeAddress.getAddressId());
		e2.setHomeAddress(homeAddress);
		session.save(e2);
		t.commit();		
	}
}

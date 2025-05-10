package in.abc.main;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.abc.Model.Employee;
import in.abc.util.HibernateUtil;

public class SelectRecordApp4 {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			Query<Employee> query = session.createQuery("FROM in.abc.Model.Employee where eno=:id");
			int id = 18;
			query.setParameter("id", id);
			
			/*
			 * Employee employee = query.uniqueResult(); if (employee != null) {
			 * System.out.println(employee); } else {
			 * System.out.println("Record not found for the given id :: " + id); }
			 */
			
			Optional<Employee> optional = query.uniqueResultOptional();
			if(optional.isPresent()) {
				Employee employee = optional.get();
				System.out.println(employee);
			} else {
				System.out.println("Record not found for the given id :: " + id);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

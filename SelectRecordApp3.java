package in.abc.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.abc.util.HibernateUtil;

public class SelectRecordApp3 {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {
			Query query = session.createQuery("SELECT ename FROM in.abc.Model.Employee where eno=:id");
			int id = 18;
			query.setParameter("id", id);

			List<String> list = query.getResultList();
			if (!list.isEmpty()) {
				String ename = list.get(0);
				System.out.println("ename is ::" + ename);
			} else {
				System.out.println("Record not found for the id :: " + id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

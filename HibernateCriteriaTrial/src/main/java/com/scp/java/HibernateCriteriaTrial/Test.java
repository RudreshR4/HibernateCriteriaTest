package com.scp.java.HibernateCriteriaTrial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Test {
	public static void main(String[] args) {

		/*
		 * Mobile m1 = new Mobile(23, "Galaxy", "Samsung"); Mobile m2 = new Mobile(24,
		 * "Xperia", "Sony"); Mobile m3 = new Mobile(25, "OneplusGT", "OnePlus"); Mobile
		 * m4 = new Mobile(26, "NotePro", "Realme");
		 */

		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Mobile.class);
		SessionFactory sf = con.buildSessionFactory();

		Session s1 = sf.openSession();
		Transaction tr = s1.beginTransaction();

		/* s1.save(m1); s1.save(m2); s1.save(m3); s1.save(m4); */

		/* String s = "from Mobile m"; */ // for all records
		/* String s = "select m.id,m.company from Mobile m"; */ // for 2 columns
		/* String s = "select m.company from Mobile m"; */ // single column
		                                                   //label Hquery fail
		/*
		 * String s = "delete from Mobile m where m.id=26"; // delete record Query q =
		 * s1.createQuery(s); int res = q.executeUpdate(); System.out.println(res);
		 */
		
		Criteria cr = s1.createCriteria(Mobile.class);
		
		/*
		 * Criterion crn = Restrictions.gt("id",23); cr.add(crn);        //Restrictions
		 */
		
		/* cr.setProjection(Projections.property("company")); */        //single col.by projections
		
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
		cr.setProjection(pl);
		
		List l = cr.list();
		
		/* q.setParameter(0, 25); */
		
		/*
		 * List<Mobile> l = q.getResultList();
		 */
		/* Iterator<Mobile> it =l.iterator(); */
		Iterator it =l.iterator();		 
		 while(it.hasNext()) 
		{  Object[] r = (Object[]) it.next();  //for 2 columns
			/* Mobile r = it.next(); */
			/* String r = (String)it.next(); */    //for one col. only that type is string
			/* System.out.println(r); */
			 System.out.println(r[0]+":"+r[1]); //for 2columns result 
			/* System.out.println("Company name:"+r); */
		 }
		 

		s1.flush();
		tr.commit();
	}
}

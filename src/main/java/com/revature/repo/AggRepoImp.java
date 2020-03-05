package com.revature.repo;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AggRepoImp {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	public SpeedResult findByName(String name) {
		String sql = "select * from speedresult where subjectName = ?";
		SQLQuery<T> query = getCurrentSession().createSQLQuery(sql);
		SpeedResult sResult = query.uniqueResult();
		return sResult;
	}
	
	

}

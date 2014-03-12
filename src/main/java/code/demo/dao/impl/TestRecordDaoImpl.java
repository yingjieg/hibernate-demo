package code.demo.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import code.demo.dao.ITestRecordDao;
import code.demo.model.TestRecord;
import code.demo.util.HibernateUtil;

public class TestRecordDaoImpl implements ITestRecordDao {

	public List<TestRecord> selectAllTestRecord() {
		Session session = HibernateUtil.getSession();
		List<TestRecord> records = session.createCriteria(TestRecord.class)
				.list();
		
		for(TestRecord r: records) {
			Hibernate.initialize(r.getPlatform());
			Hibernate.initialize(r.getResult());
			Hibernate.initialize(r.getTestPhase());
		}
		
		session.close();
		return records;
	}

	public List<TestRecord> selectTestRecordByRestrictions(Criterion criterion) {
		Session session = HibernateUtil.getSession();
		List<TestRecord> records = session.createCriteria(TestRecord.class)
				.add(criterion).list();
		return records;
	}
}

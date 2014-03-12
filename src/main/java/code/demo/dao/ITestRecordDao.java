package code.demo.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import code.demo.model.TestRecord;

public interface ITestRecordDao {
	public List<TestRecord> selectAllTestRecord();

	public List<TestRecord> selectTestRecordByRestrictions(Criterion criterion);
}

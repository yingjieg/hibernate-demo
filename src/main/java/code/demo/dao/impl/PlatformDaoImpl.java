package code.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;

import code.demo.dao.IPlatformDao;
import code.demo.model.Platform;
import code.demo.util.HibernateUtil;

public class PlatformDaoImpl implements IPlatformDao {

	public List<Platform> selectAllPlatform() {
		Session session = HibernateUtil.getSession();
		List<Platform> platforms = session.createCriteria(Platform.class)
				.list();

		session.close();
		return platforms;
	}
}
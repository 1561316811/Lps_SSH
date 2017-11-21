package clockcatagory;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TRoomcatagory entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see clockcatagory.TRoomcatagory
 * @author MyEclipse Persistence Tools
 */
public class TRoomcatagoryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TRoomcatagoryDAO.class);
	// property constants
	public static final String ROOMCATAGORY = "roomcatagory";

	public void save(TRoomcatagory transientInstance) {
		log.debug("saving TRoomcatagory instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TRoomcatagory persistentInstance) {
		log.debug("deleting TRoomcatagory instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TRoomcatagory findById(java.lang.Integer id) {
		log.debug("getting TRoomcatagory instance with id: " + id);
		try {
			TRoomcatagory instance = (TRoomcatagory) getSession().get("clockcatagory.TRoomcatagory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TRoomcatagory> findByExample(TRoomcatagory instance) {
		log.debug("finding TRoomcatagory instance by example");
		try {
			List<TRoomcatagory> results = (List<TRoomcatagory>) getSession()
					.createCriteria("clockcatagory.TRoomcatagory").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TRoomcatagory instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TRoomcatagory as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TRoomcatagory> findByRoomcatagory(Object roomcatagory) {
		return findByProperty(ROOMCATAGORY, roomcatagory);
	}

	public List findAll() {
		log.debug("finding all TRoomcatagory instances");
		try {
			String queryString = "from TRoomcatagory";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TRoomcatagory merge(TRoomcatagory detachedInstance) {
		log.debug("merging TRoomcatagory instance");
		try {
			TRoomcatagory result = (TRoomcatagory) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TRoomcatagory instance) {
		log.debug("attaching dirty TRoomcatagory instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TRoomcatagory instance) {
		log.debug("attaching clean TRoomcatagory instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
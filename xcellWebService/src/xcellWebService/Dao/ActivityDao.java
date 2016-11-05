package xcellWebService.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import xcellWebService.Modal.Activity;


@Transactional
@Repository("activityDao")
public class ActivityDao extends AbstractDao<Integer, Activity>{
	@SuppressWarnings("unchecked")	
	public List<Activity> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Activity>) criteria.list();
	}
	
	public Activity findByCode(String activityId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("activityId", activityId));
		return (Activity) criteria.uniqueResult();		
	}
	
	public void save(Activity activity) {
		persist(activity);
	}
	
	public void delete(Activity activity) {

		getSession().delete(activity);
	}
	
	public void update(Activity activity) {
		getSession().update(activity);			
	}
	
	public boolean isExist(Activity activity)
	{
		return this.findByCode(activity.getActivityId())!=null;
	}
}

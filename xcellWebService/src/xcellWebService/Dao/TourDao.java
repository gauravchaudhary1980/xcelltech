package xcellWebService.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import xcellWebService.Modal.Tour;

@Transactional
@Repository("tourDao")
public class TourDao extends AbstractDao<Integer, Tour> {
	@SuppressWarnings("unchecked")	
	public List<Tour> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Tour>) criteria.list();
	}
	
	public Tour findByCode(String tourCode) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("tourCode", tourCode));
		return (Tour) criteria.uniqueResult();		
	}
	
	public void save(Tour tour) {
		persist(tour);
	}
	
	public void delete(Tour tour) {

		getSession().delete(tour);
	}
	
	public void update(Tour tour) {
		getSession().update(tour);			
	}
	
	public boolean isExist(Tour tour)
	{
		return this.findByCode(tour.getActivityId())!=null;
	}
}

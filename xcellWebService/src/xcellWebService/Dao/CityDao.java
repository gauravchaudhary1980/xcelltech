package xcellWebService.Dao;

//import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import xcellWebService.Modal.City;

@Transactional
@Repository("cityDao")
public class CityDao extends AbstractDao<Integer, City>{
	
	@SuppressWarnings("unchecked")	
	public List<City> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<City>) criteria.list();
	}
	
	public City findByCode(String cityCode) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("cityCode", cityCode));
		return (City) criteria.uniqueResult();		
	}
	
	public void save(City city) {
		persist(city);
	}
	
	public void delete(City city) {

		getSession().delete(city);
	}
	
	public void update(City city) {
		getSession().update(city);			
	}
	
	public boolean isExist(City city)
	{
		return this.findByCode(city.getCityCode())!=null;
	}
}

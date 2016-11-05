package xcellWebService.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import xcellWebService.Modal.User;

@Transactional
@Repository("userDao")
public class UserDao extends AbstractDao<Integer, User> {
	
	@SuppressWarnings("unchecked")	
	public List<User> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}
	
	//User's unique code will be phone 
	public User findByCode(String phone) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("phone", phone));
		return (User) criteria.uniqueResult();
		
	}
	
	public void save(User user) {
		persist(user);
	}
	public void delete(User user) {

		getSession().delete(user);
	}
	public void update(User user) {
		getSession().update(user);			
	}
	
	public boolean isExist(User user)
	{
		return this.findByCode(user.getPhone())!=null;		
	}
}

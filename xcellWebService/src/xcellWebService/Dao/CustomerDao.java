package xcellWebService.Dao;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import xcellWebService.Modal.Customer;

@Transactional
@Repository("customerDao")
public class CustomerDao extends AbstractDao<Integer, Customer>{
	@SuppressWarnings("unchecked")	
	public List<Customer> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Customer>) criteria.list();
	}
	
	public Customer findByCode(String customerCode) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("customerCode", customerCode));
		return (Customer) criteria.uniqueResult();		
	}
	
	public void save(Customer customer) {
		persist(customer);
	}
	
	public void delete(Customer customer) {

		getSession().delete(customer);
	}
	
	public void update(Customer customer) {
		getSession().update(customer);			
	}
	
	public boolean isExist(Customer customer)
	{
		return this.findByCode(customer.getCustomerCode())!=null;
	}
}

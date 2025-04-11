package org.openmrs.module.basicexample.api.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.basicexample.Department;

import java.util.List;

///**
// * The default implementation of {@link DepartmentDAO}.
// */
public class HibernateDepartmentDAO implements DepartmentDAO {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	//    /**
	//     * @param sessionFactory the sessionFactory to set
	//     */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//    /**
	//     * @return the sessionFactory
	//     */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//    /**
	//     * @see org.openmrs.module.department.api.db.DepartmentDAO#getAllDepartments()
	//     */
	@Override
	public List<Department> getAllDepartments() {
		return sessionFactory.getCurrentSession().createCriteria(Department.class).list();
	}
	
	//    /**
	//     * @see org.openmrs.module.department.api.DepartmentService#getDepartment(java.lang.Integer)
	//     */
	@Override
	public Department getDepartment(Integer departmentId) {
		return (Department) sessionFactory.getCurrentSession().get(Department.class, departmentId);
	}
	
	//    /**
	//     * @see org.openmrs.module.department.api.db.DepartmentDAO#saveDepartment(org.openmrs.module.department.Department)
	//     */
	@Override
	public Department saveDepartment(Department department) {
		sessionFactory.getCurrentSession().save(department);
		return department;
	}
	
	//    /**
	//     * @see org.openmrs.module.department.api.db.DepartmentDAO#purgeDepartment(org.openmrs.module.department.Department)
	//     */
	@Override
	public void purgeDepartment(Department department) {
		sessionFactory.getCurrentSession().delete(department);
	}
}

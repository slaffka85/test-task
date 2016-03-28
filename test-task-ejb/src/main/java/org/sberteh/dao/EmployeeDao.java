package org.sberteh.dao;

import org.sberteh.model.Employee;

import javax.ejb.Stateless;

/**
 * EmployeeDao is DAO-layer for working with Employee-entity
 */
@Stateless
public class EmployeeDao extends GenericDao<Employee> {
}

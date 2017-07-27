package com.example.demo.repository;

import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.model.Employee;
import com.example.demo.model.Employee_;

public class EmployeeSpecifications {

	private EmployeeSpecifications() {

	}

	public static Specification<Employee> filterByFirstNameAndZip(final String firstName, final String lastName) {
		return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<Predicate>();
			if (StringUtils.hasText(firstName)) {
				predicates.add(cb.or(cb.like(root.get(Employee_.firstName), "%" + firstName + "%")));
			}
			
			if (StringUtils.hasText(lastName)) {
				predicates.add(cb.or(cb.like(root.get(Employee_.lastName), "%" + lastName + "%")));
			}
			
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};

	}

}

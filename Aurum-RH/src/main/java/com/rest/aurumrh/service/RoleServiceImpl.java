package com.rest.aurumrh.service;

import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.IRoleDAO;
import com.rest.aurumrh.dto.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	IRoleDAO iRoleDAO;

	@Override
	public List<Role> getAllRoles() {
		
		return iRoleDAO.findAll();
	}

	@Override
	public Role getRoleById(int id) {
		
		return iRoleDAO.findById(id).get();
	}

	@Override
	public Role createRole(Role role) {
		
		return iRoleDAO.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		
		return iRoleDAO.save(role);
	}

	@Override
	public void deleteRole(int id) {
		
		iRoleDAO.deleteById(id);
		
	}

}

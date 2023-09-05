package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Role;

public interface IRoleService {

	public List<Role> getAllRoles();

	public Role getRoleById(int id);

	public Role createRole(Role role);

	public Role updateRole(Role role);

	public void deleteRole(int id);
}
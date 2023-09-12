package com.rest.aurumrh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.aurumrh.dto.Role;
import com.rest.aurumrh.service.RoleServiceImpl;



@RestController
public class RoleController {
	
	@Autowired
	RoleServiceImpl roleServiceImpl;
	
	@GetMapping("/roles")
	public List<Role> getAllRoles() {
		
		return roleServiceImpl.getAllRoles();
	}
	
	@GetMapping("/roles/{id}")
	public Role getRoleById(@PathVariable(name = "id") int id) {
		
		return roleServiceImpl.getRoleById(id);
	}
	
	@PostMapping("/roles")
	public Role createRole(@RequestBody Role role) {
		
		return roleServiceImpl.createRole(role);
	}
	
	@PutMapping("/roles/{id}")
	public Role updateUser(@PathVariable(name = "id") int id, @RequestBody Role role) {
		
		Role selectedRole = new Role();
		Role updatedRole = new Role();
		
		selectedRole = roleServiceImpl.getRoleById(id);
		
		selectedRole.setName(role.getName());
				
		updatedRole = roleServiceImpl.updateRole(selectedRole);
		
		return updatedRole;
	}
	
	@DeleteMapping("/roles/{id}")
	public void deleteRole(@PathVariable(name = "id") int id) {
		
		roleServiceImpl.deleteRole(id);
	}
	
	@GetMapping("/roles/name/{name}")
	public Role getRoleByName(@PathVariable(name = "name") String name) {
		
		return roleServiceImpl.getRoleByName(name);
	}
}

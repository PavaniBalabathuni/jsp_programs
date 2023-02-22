package com.ty.team_jsp__mcd_project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.team_jsp__mcd_project_dto.Menu;

public class MenuDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	public Menu saveMenu(Menu menu) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return menu;
	}
	public List<Menu> getMenus(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select menu from Menu menu");
		List<Menu> list=query.getResultList();
		return list;
	}
	public boolean deleteMenu(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Menu menu=entityManager.find(Menu.class, id);
		if(menu!=null) {
			entityTransaction.begin();
			entityManager.remove(menu);
			entityTransaction.commit();
			return true;
		}
		return false;
		
	}
	public Menu getMenuById(int id) {
		EntityManager entityManager=getEntityManager();
		Menu menu=entityManager.find(Menu.class, id);
		return menu;
		
	}
	public Menu updateMenu(Menu menu) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();
		return menu;
		
		
	}
	
	

}

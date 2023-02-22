package com.ty.team_jsp__mcd_project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.team_jsp__mcd_project_dto.FoodOrder;
import com.ty.team_jsp__mcd_project_dto.Items;

public class FoodOrderDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public FoodOrder saveOrder(FoodOrder foodOrder) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}

	public boolean removeFoodOrder(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entity = entityManager.getTransaction();
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		
		if (foodOrder != null) {
			entity.begin();
			List<Items> list = foodOrder.getList();
			for (Items items : list) {
				
				entityManager.remove(items);
				
			}
              entityManager.remove(foodOrder);
              entity.commit();
              return true;
		}
		return false;

	}
	public FoodOrder getFoodOrderByEmail(String email) {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select fo from FoodOrder fo where fo.email=?1");
		query.setParameter(1, email);
		FoodOrder foodOrder=(FoodOrder)query.getSingleResult();
		return foodOrder;
	}

}

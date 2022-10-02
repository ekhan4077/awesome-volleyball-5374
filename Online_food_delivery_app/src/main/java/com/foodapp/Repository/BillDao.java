package com.foodapp.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer> {
	
	
	@Query("SELECT b FROM Bill b WHERE b.billDate BETWEEN ?1 AND ?2")
	
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate);

	public List<Bill> findAllBybillId(Integer custId);
	
	
}

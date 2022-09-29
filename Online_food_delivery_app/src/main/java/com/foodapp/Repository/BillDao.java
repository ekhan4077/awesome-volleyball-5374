package com.foodapp.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer> {
	
//	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate);
	
	
}

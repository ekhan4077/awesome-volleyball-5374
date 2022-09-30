package com.foodapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.BillException;
import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.Bill;


@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private com.foodapp.Repository.BillDao billdao;

	
	@Override
	public Bill addBill(Bill bill) throws BillException {
		Optional<Bill> opt = billdao.findById(bill.getBillId());
		if (opt.isPresent()) {
			throw new BillException("Bill is Already generated");
		}

		return billdao.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		Optional<Bill> opt = billdao.findById(bill.getBillId());
		if (!opt.isPresent()) {
			throw new BillException("Bill not Exist");
		}

		return billdao.save(bill);

	}

	@Override
	public Bill removeBill(Bill bill) throws BillException {

		Optional<Bill> opt = billdao.findById(bill.getBillId());
		if (!opt.isPresent()) {
			throw new BillException("Bill not Exist");
		}

		billdao.delete(bill);
		return opt.get();
	}

	@Override
	public Bill viewBill(Bill bill) throws BillException {
		Optional<Bill> opt = billdao.findById(bill.getBillId());
		if (!opt.isPresent()) {
			throw new BillException("Bill not Exist");
		}

		return opt.get();
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException {
    List<Bill> li=billdao.findAll();
    if(li.size()==0) {
    	throw new BillException("there is no Bill between the  given Date");
    }
    List<Bill> list=new ArrayList<>();
		for(Bill b:li) {
			if(startDate.isAfter(LocalDate.from(b.getBillDate()))&&endDate.isBefore(LocalDate.from(b.getBillDate()))) {
				list.add(b);
				
			}
			else if(startDate.isEqual(LocalDate.from(b.getBillDate()))||endDate.isEqual(LocalDate.from(b.getBillDate()))) {
				list.add(b);
			}
			
		}
		return list;
	}

	@Override
	public List<Bill> viewBills(Integer custId) throws BillException, CustomerException {
		List<Bill> li = billdao.findAllBybillId(custId);
		if (li.size() == 0) {
			throw new BillException("Bill not Exists for given ID");
		}

		return li;
	}

	@Override
	public Double calculateTotalCost(Bill bill) throws BillException {
		Optional<Bill> opt = billdao.findById(bill.getBillId());
		if (!opt.isPresent()) {
			throw new BillException("Bill not Exist");
		}

		return opt.get().getTotalCost();
	}

}

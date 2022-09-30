package com.foodapp.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.foodapp.ServiceImpl.BillServiceImpl;
import com.foodapp.exceptions.BillException;
import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.Bill;

@RestController
@RequestMapping("bill")
public class BillServiceController {
	@Autowired
	private BillServiceImpl service;

	@PostMapping("/bill")
	public ResponseEntity<Bill> generateBill(@RequestBody Bill bill) throws BillException {
		Bill myBill = service.addBill(bill);
		return new ResponseEntity<Bill>(myBill, HttpStatus.CREATED);

	}

	@PutMapping("/bill")
	public ResponseEntity<Bill> UpdateBill(@RequestBody Bill bill) throws BillException {
		Bill myBill = service.updateBill(bill);
		return new ResponseEntity<Bill>(myBill, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/bill")
	public ResponseEntity<Bill> DeleteBill(@RequestBody Bill bill) throws BillException {
		Bill myBill = service.removeBill(bill);
		return new ResponseEntity<Bill>(myBill, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bill1")
	public ResponseEntity<Bill> viewBill(@RequestBody Bill bill) throws BillException, CustomerException {
		Bill myBill = service.viewBill(bill);
		return new ResponseEntity<Bill>(myBill, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bill/{id}")
	public ResponseEntity<List<Bill>> viewAllBill(@PathVariable("id") Integer id)
			throws BillException, CustomerException {
		List<Bill> myBill = service.viewBills(id);
		return new ResponseEntity<List<Bill>>(myBill, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bill")
	public ResponseEntity<Double> getTotalCost(@RequestBody Bill bill) throws BillException {
		Double myCost = service.calculateTotalCost(bill);
		return new ResponseEntity<Double>(myCost, HttpStatus.ACCEPTED);

	}
	@GetMapping("/bills")
	public ResponseEntity<List<Bill>> viewBillsBetweenDates(@RequestBody List<String> li) throws BillException {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate localDate1 = LocalDate.parse(li.get(0), dtf);
		 LocalDate localDate2 = LocalDate.parse(li.get(1), dtf);
		List<Bill>list= service.viewBills(localDate1, localDate2);
		 
		return new ResponseEntity<List<Bill>>(list, HttpStatus.ACCEPTED);

	}

}

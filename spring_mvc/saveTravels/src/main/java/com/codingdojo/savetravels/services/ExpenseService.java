package com.codingdojo.savetravels.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> expense = expenseRepository.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		
		return null;
	}
	
	public Expense updateExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	public Expense updateExpense(Long id, String name, String vendor, BigDecimal amount, String description) {
		Expense expense = findExpense(id);
		
		if (expense != null) {
			expense.setName(name);
			expense.setVendor(vendor);
			expense.setAmount(amount);
			expense.setDescription(description);
		}
		
		return expenseRepository.save(expense);
	}
	
	public void deleteExpense(Long id) {
		Expense expense = findExpense(id);
		if (expense != null) {
			expenseRepository.delete(expense);
		}
	}
}

package com.example.myapplication

class FinanceManager {
    private val lastName = "Oganiani"
    private val birthMonth = 4 // April

    fun calculateFinance(salary: Double, rent: Double, food: Double): FinanceModel {
        val totalExpenses = rent + food
        val remainingBalance = salary - totalExpenses
        val savingsPercent = lastName.length + birthMonth // 8 + 4 = 12
        val recommendedSavings = salary * (savingsPercent / 100.0)
        val isDeficit = salary < totalExpenses

        return FinanceModel(
            salary = salary,
            rent = rent,
            food = food,
            totalExpenses = totalExpenses,
            remainingBalance = remainingBalance,
            recommendedSavings = recommendedSavings,
            isDeficit = isDeficit
        )
    }
}
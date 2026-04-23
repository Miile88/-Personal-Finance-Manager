package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FinanceModel(
    val salary: Double,
    val rent: Double,
    val food: Double,
    val totalExpenses: Double,
    val remainingBalance: Double,
    val recommendedSavings: Double,
    val isDeficit: Boolean
) : Parcelable
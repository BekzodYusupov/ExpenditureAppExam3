package uz.gita.examgroup3.domain.usecase

import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity

interface TransactionUseCase {
    fun saveTransaction(expenditureEntity: ExpenditureEntity)
}
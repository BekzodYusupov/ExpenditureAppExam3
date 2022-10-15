package uz.gita.examgroup3.domain.usecase.impl

import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import uz.gita.examgroup3.domain.usecase.TransactionUseCase
import javax.inject.Inject

class TransactionUseCaseImpl @Inject constructor(private val expenditureRepository: ExpenditureRepository) :
    TransactionUseCase {
    override fun saveTransaction(expenditureEntity: ExpenditureEntity) =
        expenditureRepository.insertExpenditure(expenditureEntity)
}
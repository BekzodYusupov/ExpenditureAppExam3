package uz.gita.examgroup3.domain.repository.impl

import uz.gita.examgroup3.data.local.room.dao.ExpenditureDao
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import javax.inject.Inject

class ExpenditureRepositoryImpl @Inject constructor(
    private val expenditureDao: ExpenditureDao
): ExpenditureRepository
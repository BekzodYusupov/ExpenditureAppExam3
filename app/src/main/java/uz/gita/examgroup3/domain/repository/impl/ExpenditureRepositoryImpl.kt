package uz.gita.examgroup3.domain.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.examgroup3.data.local.shared_pref.ShP
import uz.gita.examgroup3.data.local.room.dao.ExpenditureDao
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import javax.inject.Inject

class ExpenditureRepositoryImpl @Inject constructor(
    private val expenditureDao: ExpenditureDao,
    private val mShP: ShP
): ExpenditureRepository {

    override suspend fun isIntroOpen(state:Boolean): Flow<Boolean> = flow {
        if (!mShP.isInit) {
            emit(mShP.isInit)
            mShP.isInit = state
        }
    }.flowOn(Dispatchers.IO)

}
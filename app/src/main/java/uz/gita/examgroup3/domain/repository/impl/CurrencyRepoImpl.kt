package uz.gita.examgroup3.domain.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.examgroup3.data.local.shared_pref.ShP
import uz.gita.examgroup3.domain.repository.CurrencyRepo
import javax.inject.Inject

class CurrencyRepoImpl @Inject constructor(private val mShP: ShP) : CurrencyRepo {

    override fun updateCurrency(currency: String) {
        mShP.currency = currency
    }

    override fun getCurrency(): Flow<String> = flow {
        emit(mShP.currency)
    }.flowOn(Dispatchers.IO)

}
package uz.gita.examgroup3.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity
import uz.gita.examgroup3.data.local.shared_pref.ShP
import uz.gita.examgroup3.data.model.CBUData
import uz.gita.examgroup3.data.remote.api.CBUApi
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import uz.gita.examgroup3.domain.usecase.CurrencyUseCase
import uz.gita.examgroup3.presentation.utils.hasConnection
import javax.inject.Inject

class CurrencyUseCaseImpl @Inject constructor(
    private val mShP: ShP,
    private val expenditureRepository: ExpenditureRepository,
    private val cbuApi: CBUApi
) : CurrencyUseCase {

    override fun updateCurrency(newCurrency: String): Boolean {
        var isSuccess = false
        if (newCurrency != mShP.currency) {
            if (hasConnection()) {
                cbuApi.getCurrency()
                    .onEach {
                        if (it.isSuccessful) {
                            converter(newCurrency, mShP.currencyName, it.body()!!)
                            isSuccess = true
                        }
                    }
                    .flowOn(Dispatchers.IO)
            } else {
                return isSuccess
            }
        }
        // Ma'lumotlar convert bo'lsa true aks holda false qaytaradi.
        // Sababi false qaytarsa internetni yoqish kerakligini ogohlantirish kerak
        return isSuccess

    }

    override fun getCurrency(): Flow<String> = flow {
        emit(mShP.currency)
    }.flowOn(Dispatchers.IO)

    private fun converter(newCurrency: String, oldCurrency: String, cbuList: List<CBUData>) {
        var oldAmount = 0.0
        var newAmount = 0.0
        val list: ArrayList<ExpenditureEntity> = ArrayList()

        expenditureRepository.getAllExpenditure()
            .onEach {
                list.addAll(it)
            }.flowOn(Dispatchers.IO)

        cbuList.forEach { cbu ->
            if (cbu.ccy == oldCurrency) {
                oldAmount = cbu.rate.toDouble()
            }
            if (cbu.ccy == newCurrency) {
                newAmount = cbu.rate.toDouble()
            }
        }

        val newList = ArrayList<ExpenditureEntity>()
        list.forEach {
            newList.add(it.copy(amount = (it.amount * (oldAmount / newAmount))))
        }

        expenditureRepository.updateAllExpenditure(newList)
        mShP.currency = when (newCurrency) {
            "USD" -> "\$"
            "JPY" -> "¥"
            "GBP" -> "£"
            "AZN" -> "₼"
            "EUR" -> "€"
            "BGN" -> "¥"
            else -> "U"
        }
        mShP.currencyName = newCurrency
    }
}
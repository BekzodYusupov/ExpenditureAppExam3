package uz.gita.examgroup3.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity
import uz.gita.examgroup3.data.local.shared_pref.ShP
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import uz.gita.examgroup3.domain.usecase.CurrencyUseCase
import javax.inject.Inject

class CurrencyUseCaseImpl @Inject constructor(
    private val mShP: ShP,
    private val expenditureRepository: ExpenditureRepository
) : CurrencyUseCase {

    override fun updateCurrency(currency: String) {
        if (currency != mShP.currency) {
            val list: ArrayList<ExpenditureEntity> = ArrayList()

            expenditureRepository.getAllExpenditure()
                .onEach {
                    list.addAll(it)
                }.flowOn(Dispatchers.IO)

            when (currency) {
                "\$" -> {

                }
                "¥" -> {

                }
                "₡" -> {

                }
                "£" -> {

                }
                "₼" -> {

                }
                "€" -> {

                }
                "лв" -> {

                }
                "đ" -> {

                }

            }

        }
    }

    override fun getCurrency(): Flow<String> = flow<String> {
        emit(mShP.currency)
    }.flowOn(Dispatchers.IO)

}
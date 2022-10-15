package uz.gita.examgroup3.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.examgroup3.domain.usecase.*
import uz.gita.examgroup3.domain.usecase.impl.*

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindsIntro(impl: IntroUseCaseImpl): IntroUseCase

    @Binds
    fun bindsSplash(impl: SplashUseCaseImpl): SplashUseCase

    @Binds
    fun bindsCurrency(impl: CurrencyUseCaseImpl): CurrencyUseCase

    @Binds
    fun bindsTransaction(impl: TransactionUseCaseImpl): TransactionUseCase

    @Binds
    fun bindsEditCategory(impl: EditCategoryUseCaseImpl): EditCategoryUseCase

    @Binds
    fun bindsCategory(impl: CategoryUseCaseImpl): CategoryUseCase
}
package uz.gita.examgroup3.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.examgroup3.domain.repository.CategoryRepository
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import uz.gita.examgroup3.domain.repository.impl.CategoryRepositoryImpl
import uz.gita.examgroup3.domain.repository.impl.ExpenditureRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsRepo(impl: ExpenditureRepositoryImpl): ExpenditureRepository

    @Binds
    fun bindsRepo(impl: CategoryRepositoryImpl): CategoryRepository


}
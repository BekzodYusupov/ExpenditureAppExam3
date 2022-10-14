package uz.gita.examgroup3.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.examgroup3.data.local.room.AppDatabase
import uz.gita.examgroup3.data.local.room.dao.CategoryDao
import uz.gita.examgroup3.data.local.room.dao.ExpenditureDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "expenditureApp.db").build()

    @Provides
    @Singleton
    fun provideExpenditure(appDatabase: AppDatabase): ExpenditureDao = appDatabase.expenditureDao()

    @Provides
    @Singleton
    fun provideCategory(appDatabase: AppDatabase): CategoryDao = appDatabase.categoryDao()
}
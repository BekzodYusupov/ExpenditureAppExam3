package uz.gita.examgroup3.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.examgroup3.domain.usecase.IntroUseCase
import uz.gita.examgroup3.domain.usecase.impl.IntroUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindsIntro(impl: IntroUseCaseImpl): IntroUseCase
}
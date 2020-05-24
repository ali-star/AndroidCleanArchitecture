package alistar.androidcleanarchitecture.internal.di.modules

import alistar.androidcleanarchitecture.App
import alistar.data.RemoteRepoImpl
import alistar.domain.repositories.RemoteRepo
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    private lateinit var app: App

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = app

    @Provides
    @Singleton
    fun provideRemoteRepo(remoteRepoImpl: RemoteRepoImpl): RemoteRepo = remoteRepoImpl

}
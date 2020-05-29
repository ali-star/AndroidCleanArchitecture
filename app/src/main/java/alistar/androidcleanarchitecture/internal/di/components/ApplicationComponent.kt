package alistar.androidcleanarchitecture.internal.di.components

import alistar.androidcleanarchitecture.App
import alistar.androidcleanarchitecture.internal.di.modules.ApplicationModule
import alistar.androidcleanarchitecture.internal.di.modules.BindingModule
import alistar.core.data.RemoteRepo
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, BindingModule::class])
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): ApplicationComponent
    }

    fun context(): Context

    fun remoteRepo(): RemoteRepo

}
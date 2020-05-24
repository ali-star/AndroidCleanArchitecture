package alistar.androidcleanarchitecture.internal.di.modules

import alistar.androidcleanarchitecture.internal.di.ViewModelBuilder
import alistar.androidcleanarchitecture.internal.di.ViewModelKey
import alistar.androidcleanarchitecture.internal.di.scopes.ActivityScope
import alistar.androidcleanarchitecture.internal.ui.screens.mainactivity.MainActivity
import alistar.androidcleanarchitecture.internal.ui.screens.mainactivity.MainViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

}
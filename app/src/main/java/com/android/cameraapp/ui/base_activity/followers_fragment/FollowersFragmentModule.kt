package com.android.cameraapp.ui.base_activity.followers_fragment

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.android.cameraapp.data.data_models.UserCollection
import com.android.cameraapp.di.base_activity.followers_fragment.FollowersFragmentScope
import dagger.Module
import dagger.Provides

@Module
object FollowersFragmentModule {

    @Provides
    @FollowersFragmentScope
    @JvmStatic
    fun getPageConfig(): PagedList.Config = PagedList.Config.Builder().setPageSize(10).setEnablePlaceholders(false).setInitialLoadSizeHint(20).build()

    @Provides
    @FollowersFragmentScope
    @JvmStatic
    fun getPagedListLiveData(pagedListConfig: PagedList.Config, dataSourceFactory: FollowersDataSourceFactory) : LiveData<PagedList<UserCollection.Followers>> {
        return LivePagedListBuilder(dataSourceFactory, pagedListConfig).build()
    }

}
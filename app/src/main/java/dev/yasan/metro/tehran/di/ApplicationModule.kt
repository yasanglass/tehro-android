package dev.yasan.metro.tehran.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.dao.DatabaseInformationDAO
import dev.yasan.metro.tehran.data.db.dao.IntersectionDAO
import dev.yasan.metro.tehran.data.db.dao.LineDAO
import dev.yasan.metro.tehran.data.db.dao.StationDAO
import dev.yasan.metro.tehran.data.repo.dbinfo.DatabaseInformationRepository
import dev.yasan.metro.tehran.data.repo.dbinfo.DatabaseInformationRepositoryImp
import dev.yasan.metro.tehran.data.repo.intersection.IntersectionRepository
import dev.yasan.metro.tehran.data.repo.intersection.IntersectionRepositoryImp
import dev.yasan.metro.tehran.data.repo.line.LineRepository
import dev.yasan.metro.tehran.data.repo.line.LineRepositoryImp
import dev.yasan.metro.tehran.data.repo.station.StationRepository
import dev.yasan.metro.tehran.data.repo.station.StationRepositoryImp
import dev.yasan.metro.tehran.util.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }

    @Singleton
    @Provides
    fun provideMetroDatabase(
        app: Application,
        callback: MetroDatabase.CallBack
    ) = Room.databaseBuilder(
        app,
        MetroDatabase::class.java,
        MetroDatabase.METRO_TEHRAN_DATABASE_NAME
    ).createFromAsset(MetroDatabase.METRO_TEHRAN_DATABASE_FILE_NAME)
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideDatabaseInformationDAO(metroDatabase: MetroDatabase) =
        metroDatabase.databaseInformationDAO()

    @Provides
    fun provideInterchangeDAO(metroDatabase: MetroDatabase) = metroDatabase.interchangeDAO()

    @Provides
    fun provideLineDAO(metroDatabase: MetroDatabase) = metroDatabase.lineDAO()

    @Provides
    fun provideStationDAO(metroDatabase: MetroDatabase) = metroDatabase.stationDAO()

    @Singleton
    @Provides
    fun provideLineRepository(lineDAO: LineDAO): LineRepository =
        LineRepositoryImp(lineDAO = lineDAO)

    @Singleton
    @Provides
    fun provideStationRepository(stationDAO: StationDAO): StationRepository =
        StationRepositoryImp(stationDAO = stationDAO)

    @Singleton
    @Provides
    fun provideInterchangeRepository(IntersectionDAO: IntersectionDAO): IntersectionRepository =
        IntersectionRepositoryImp(IntersectionDAO = IntersectionDAO)

    @Singleton
    @Provides
    fun provideDatabaseInformationRepository(databaseInformationDAO: DatabaseInformationDAO): DatabaseInformationRepository =
        DatabaseInformationRepositoryImp(databaseInformationDAO = databaseInformationDAO)

}

package dev.yasan.metro.tehran.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.yasan.metro.tehran.data.repository.accessibility.AccessibilityRepositoryImp
import dev.yasan.metro.tehran.data.repository.dbinfo.DatabaseInformationRepositoryImp
import dev.yasan.metro.tehran.data.repository.intersection.IntersectionRepositoryImp
import dev.yasan.metro.tehran.data.repository.line.LineRepositoryImp
import dev.yasan.metro.tehran.data.repository.stat.StatRepositoryImp
import dev.yasan.metro.tehran.data.repository.station.StationRepositoryImp
import dev.yasan.metro.tehran.data.source.local.database.MetroDatabase
import dev.yasan.metro.tehran.data.source.local.database.dao.AccessibilityLevelBlindnessDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.AccessibilityLevelWheelchairDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.DatabaseInformationDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.IntersectionDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.LineDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.StationDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.WcAvailabilityLevelDAO
import dev.yasan.metro.tehran.domain.repository.accessibility.AccessibilityRepository
import dev.yasan.metro.tehran.domain.repository.dbinfo.DatabaseInformationRepository
import dev.yasan.metro.tehran.domain.repository.intersection.IntersectionRepository
import dev.yasan.metro.tehran.domain.repository.line.LineRepository
import dev.yasan.metro.tehran.domain.repository.stat.StatRepository
import dev.yasan.metro.tehran.domain.repository.station.StationRepository
import glass.yasan.kit.core.DispatcherProvider
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
    fun provideWcAvailabilityLevelDAO(metroDatabase: MetroDatabase) = metroDatabase.wcAvailabilityLevelDAO()

    @Provides
    fun provideLineDAO(metroDatabase: MetroDatabase) = metroDatabase.lineDAO()

    @Provides
    fun provideAccessibilityLevelBlindnessDAO(metroDatabase: MetroDatabase) =
        metroDatabase.accessibilityLevelBlindnessDAO()

    @Provides
    fun provideAccessibilityLevelWheelchairDAO(metroDatabase: MetroDatabase) =
        metroDatabase.accessibilityLevelWheelchairDAO()

    @Provides
    fun provideStationDAO(metroDatabase: MetroDatabase) = metroDatabase.stationDAO()

    @Singleton
    @Provides
    fun provideLineRepository(lineDAO: LineDAO): LineRepository =
        LineRepositoryImp(lineDAO = lineDAO)

    @Singleton
    @Provides
    fun provideStationRepository(
        stationDAO: StationDAO,
        intersectionRepository: IntersectionRepository,
        lineRepository: LineRepository,
        accessibilityRepository: AccessibilityRepository
    ): StationRepository =
        StationRepositoryImp(
            stationDAO = stationDAO,
            intersectionRepository = intersectionRepository,
            lineRepository = lineRepository,
            accessibilityRepository = accessibilityRepository
        )

    @Singleton
    @Provides
    fun provideInterchangeRepository(intersectionDAO: IntersectionDAO): IntersectionRepository =
        IntersectionRepositoryImp(intersectionDAO = intersectionDAO)

    @Singleton
    @Provides
    fun provideDatabaseInformationRepository(databaseInformationDAO: DatabaseInformationDAO): DatabaseInformationRepository =
        DatabaseInformationRepositoryImp(databaseInformationDAO = databaseInformationDAO)

    @Singleton
    @Provides
    fun provideAccessibilityRepository(
        accessibilityLevelBlindnessDAO: AccessibilityLevelBlindnessDAO,
        accessibilityLevelWheelchairDAO: AccessibilityLevelWheelchairDAO,
        wcAvailabilityLevelDAO: WcAvailabilityLevelDAO
    ): AccessibilityRepository = AccessibilityRepositoryImp(
        accessibilityLevelBlindnessDAO = accessibilityLevelBlindnessDAO,
        accessibilityLevelWheelchairDAO = accessibilityLevelWheelchairDAO,
        wcAvailabilityLevelDAO = wcAvailabilityLevelDAO
    )

    @Singleton
    @Provides
    fun provideStatRepository(
        intersectionDAO: IntersectionDAO,
        lineDAO: LineDAO,
        stationRepository: StationRepository,
        accessibilityRepository: AccessibilityRepository
    ): StatRepository =
        StatRepositoryImp(
            intersectionDAO = intersectionDAO,
            lineDAO = lineDAO,
            stationRepository = stationRepository,
            accessibilityRepository = accessibilityRepository
        )
}

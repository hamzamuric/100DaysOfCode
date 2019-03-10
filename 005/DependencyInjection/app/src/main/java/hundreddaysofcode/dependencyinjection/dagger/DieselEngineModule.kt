package hundreddaysofcode.dependencyinjection.dagger

import dagger.Binds
import dagger.Module
import hundreddaysofcode.dependencyinjection.car.DieselEngine
import hundreddaysofcode.dependencyinjection.car.Engine

@Module
abstract class DieselEngineModule {

    @Binds
    abstract fun bindEngine(engine: DieselEngine): Engine
}
package hundreddaysofcode.dependencyinjection.dagger

import dagger.Binds
import dagger.Module
import hundreddaysofcode.dependencyinjection.car.Engine
import hundreddaysofcode.dependencyinjection.car.PetrolEngine

@Module
abstract class PetrolEngineModule {

    @Binds
    abstract fun bindEngine(engine: PetrolEngine): Engine
}
package hundreddaysofcode.dependencyinjection.dagger

import dagger.Module
import dagger.Provides
import hundreddaysofcode.dependencyinjection.car.Rims
import hundreddaysofcode.dependencyinjection.car.Tires
import hundreddaysofcode.dependencyinjection.car.Wheels

@Module
class WheelsModule {

    companion object {

        @Provides
        fun proveideRims() = Rims()

        @Provides
        fun provideTires(): Tires {
            val tires = Tires()
            tires.inflate()
            return tires
        }

        @Provides
        fun provideWheels(rims: Rims, tires: Tires) =
            Wheels(rims, tires)
    }
}
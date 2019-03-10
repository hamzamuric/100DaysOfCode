package hundreddaysofcode.dependencyinjection.dagger

import dagger.Component
import hundreddaysofcode.dependencyinjection.car.Car

@Component(modules = [WheelsModule::class, DieselEngineModule::class])
interface CarComponent {

    fun getCar(): Car

    fun inject(mainActivity: MainActivity)
}
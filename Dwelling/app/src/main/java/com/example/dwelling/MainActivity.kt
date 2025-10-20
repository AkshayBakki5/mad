
fun main(){
    val roundHut=RoundHut(3,10.0)
    val squareCabin=SquareCabin(8,15.0)
    val roundtower=Roundtower(2,5.0,5)
    print("Round Hut")
    roundHut.getInfo()
    print("Square Cabin")
    squareCabin.getInfo()
    print("Round")
    roundtower.getInfo()
}

open class Dwelling(var residents: Int){
    open val buildingmaterial: String="Unknown"
    open val capacity: Int=0
    fun hasRoom(): Boolean{
        return residents<capacity
    }
    open fun getFloorArea(): Double{
        return 0.0
    }
    fun getInfo(){
        print("Building Material :$buildingmaterial \n")
        print("Capacity :$capacity \n")
        print("Resindents : $residents\n")
        print("Has Room :${hasRoom()}\n")
        print("Get floor area :${getFloorArea()}\n")
        print("---------\n")
    }
}
open class RoundHut(residents: Int,val radius: Double):Dwelling(residents){
    override val buildingmaterial: String ="Wood"
    override val capacity : Int=4
    override fun getFloorArea(): Double{
        return Math.PI*radius*radius
    }
}
open class SquareCabin(residents: Int,val side: Double):Dwelling(residents){
    override val buildingmaterial: String="Straw"
    override val capacity: Int = 6
    override fun getFloorArea(): Double {
        return side*side
    }
}
class Roundtower(residents: Int,radius: Double,val floors: Int=2): RoundHut(residents,radius){
    override val buildingmaterial: String = "Stone"
    override val capacity: Int = 6*floors
    override fun getFloorArea(): Double {
        return super.getFloorArea()*floors
    }
}

package dk.easj.anbo.nameagesafeargs

import java.io.Serializable

data class Person(val name: String, val age: Int) : Serializable {
    // https://stackoverflow.com/questions/35970957/how-to-extend-a-data-class-with-tostring
    override fun toString(): String {
        return "$name $age"
    }
}

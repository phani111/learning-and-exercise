class Person(val name: String, var age: Int)
val p = new Person("Tom", 18)
p.name = "Cat" // Error
p.age = 19 // Okay
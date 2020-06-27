//fun checkValue(){
//    println("Type numbers to check value: ")
//    val first = readLine()!!.toInt()
//    val second = readLine()!!.toInt()
//    val result = first % second
//
//    if (result == 0) {
//        println("number: $result is even")
//    } else {
//        println("number: $result is odd")
//    }
//}

// for loop with pre defined range and step method
fun doLoop() {
//    for (i in 1..10) {
//        println("iteration number: $i")
//    }
//    for (i: Int in 1..10 step 2) {
//        println("iteration number: $i")
//    }

//    to decrement use the downTo keyword
//    for (i:Int in 10 downTo 0) {
//        println("iteration number: $i")
//    }

//    while training
//    var i = 1
//    while (i <= 10) {
//        println("$i")
//        i += 1
//    }

//    do while training
//    var i = 1
//
//    do {
//        println("$i")
//        i += 1
//    } while (i <= 10)

//    breaking syntax for internal loops using @loop
//    without the @loop syntax, the break statement would've only stopped the inner loop (the one closest)
//    with @loop i can define the breaking loop
//    loop@ for (n in 1..10){
//        println("n $n")
////        inner loop
//        for (i in 1..9) {
//            println("i $i")
//            if (i == 5) {
//                break@loop
//            }
//        }
// Creating array from input, arrays are fixed sized, to use dynamic array use ArrayList()
// until keyword: go to range but without include last value, same as maxSize - 1 useful for last element in array index (array.length -1 equivalent)
//    print("enter number of todos: ")
//    val maxSize = readLine()!!.toInt()
//    val todos = Array(maxSize) { "" }
//    for (i in 0 until maxSize) {
//        print("type todo: ")
//        todos[i] = readLine()!!.toString()
//    }
//    println("todos")
//    for (n in 0 until maxSize) {
//        println("todo: $n ${todos[n]}")
//    }

//    ArrayList()
    println("Todo List")
    val todos = ArrayList<String>()

    do {
        print("type todo or type quit to exit program: ")
        val todo = readLine()!!.toString()
        if (todo != "quit") {
            todos.add(todo)
        }
    } while (todo != "quit")

    println("todos")
    for (todo in todos) {
        println("todo: $todo")
    }
}


fun main() {
    doLoop()
//    var i = 5
//    println(++i)
//    print(--i)
}
val number = "Scala"

(1 to number.length).toSet

val x = List("hello", "world")

x.foldLeft(""){
    (accum, s) => accum ++ s
}
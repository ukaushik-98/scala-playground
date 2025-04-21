def product(fn: (Int) => Int)(a: Int, b: Int): Int = 
    if a > b then 1 else fn(a) * product(fn)(a + 1, b)

def factorial(b: Int) = product(x => x)(1, b)


def mapReduce(map: Int => Int)(reduce: (Int, Int) => Int)(base: Int)(a: Int, b: Int): Int =
    if a > b then base else reduce(map(a), mapReduce(map)(reduce)(base)(a+1, b))

def sum(f: Int => Int) = mapReduce(f)((x, y) => x + y)(0)

sum(factorial)(1, 5)


def f(a: String)(b: Int)(c: Boolean): String =
  "(" + a + ", " + b + ", " + c + ")"

val partialApplication1 = f("Scala")

val partialApplication2 = partialApplication1(42)
package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    // println("Pascal's Triangle")
    // for row <- 0 to 10 do
    //   for col <- 0 to row do
    //     print(s"${pascal(col, row)} ")
    //   println()
    println(countChange(4,List(1,2)))

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    def helper(row: Int, column: Int): Int =
      if row <= 1 || column == row || column == 0 then 1 else helper(row - 1, column - 1) + helper(row - 1, column) 
    helper(r, c)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
    def modifier(c: Char): Int =
      c match
        case '(' => 1
        case ')' => -1
        case _ => 0 

    def helper(index: Int, accum: Int): Boolean =
      (accum, index) match
        case (a, _)  if a < 0 => false
        case (_, index) if index == chars.length => accum == 0
        case (_, _) => helper(index + 1, accum + modifier(chars(index)))

    helper(0, 0)

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    (money, coins) match
      case (0, _) => 1
      case (m, _) if m < 0 => 0 
      case (_, Nil) => 0
      case (m, c :: cs) =>
        countChange(m, cs) + countChange(m - c, coins) 
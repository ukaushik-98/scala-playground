package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    testPascal()
    testBalance()

  def testPascal(): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do print(s"${pascal(col, row)} ")
      println()

  def testBalance(): Unit =
    println("Balance")
    println(balance(List(':', '-', ')', ')')))
    println(balance(List('(', '(', '-', ')', ')')))

  /** Exercise 1
    */

  /** r,c 4,3 3,2 -> 3 + 3,3 -> 1 = 4 2,1 -> 2 + 2,2 -> 1 = 3 1,0 -> 1 + 1,1 ->
    * 1 = 2
    */
  def pascal(c: Int, r: Int): Int =
    if c == 0 || r == 0 || c >= r then 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)

  /** Exercise 2
    */
  def balance(chars: List[Char]): Boolean =
    def recurHelper(chars: List[Char], acc: Int): Boolean =
      if chars.length == 0 then acc == 0
      else if acc < 0 then false
      else if chars.head == '(' then recurHelper(chars.tail, acc + 1)
      else if chars.head == ')' then recurHelper(chars.tail, acc - 1)
      else recurHelper(chars.tail, acc)
    recurHelper(chars, 0)

  /** Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int =
    def recurHelper(accum: Int, n: Int): Int =
      // base case we found an exact match
      if accum == 0 then 1
      // we've found a negative sum and can't find change
      else if accum < 0 then 0
      // we still have change left and we've run out of coins
      else if n <= 0 && accum >= 1 then 0
      else
        // calculate with the coin or without the coin
        recurHelper(accum, n - 1) + recurHelper(accum - coins(n - 1), n)
    recurHelper(money, coins.length)

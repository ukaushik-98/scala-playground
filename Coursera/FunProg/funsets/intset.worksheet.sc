trait IntSet:
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean
    def union(other: IntSet): IntSet

class EmptySet extends IntSet

    override def incl(x: Int): IntSet = NonEmptySet(x, EmptySet(), EmptySet())

    override def contains(x: scala.Int): Boolean = false

    override def union(other: IntSet): IntSet = other


// class NonEmptySet[T](x: T, left: IntSet, right: IntSet) extends IntSet

//     override def incl(x: scala.Int): IntSet = ???

//     override def contains(x: scala.Int): Boolean = ???

//     override def union(other: IntSet): IntSet = ???



// class Dumbo extends IntSet

//     override def incl(x: Int): IntSet = ???

//     override def contains(x: Int): Boolean = ???

//     override def union(other: IntSet): IntSet = ???
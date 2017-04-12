import org.apache.spark.SparkContext

class Aggregations (sc : SparkContext) {
   def aggregate () = {
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data)
        // sum
        rdd.aggregate(0)((x, y) => x + y, (a, b) => a + b)
        // sum and count
        rdd.aggregate((0, 0))((x, y) => (x._1 + y, x._2 + 1), (a, b) => (a._1 + b._1, a._2 + b._2))
    }

    def fold () = {
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data)
        val result = rdd.fold(0)((a, b) => a + b)
    }

    def reduce () = {
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data)
        val result = rdd.reduce((a, b) => a + b)
    }

    // Pair RDD
    def reduceByKey () = {
        val data = Array(("a", 3), ("b", 4), ("a", 1))
        val pairRdd = sc.parallelize(data)
        val result = pairRdd.reduceByKey((x, y) => x + y)
    }

    def join () = {
        val personAddress = sc.parallelize(Array(("Tom", "Road #135"), ("Jerry", "Street 156"), ("Jack", "Seattle")))
        val personAge = sc.parallelize(Array(("Tom", 18), ("Jerry", 19)))

        val joinResult = personAddress.join(personAge)
        val leftOuterJoinResult = personAddress.leftOuterJoin(personAge)
        var rightOuterJoinResult = personAddress.rightOuterJoin(personAge)
    }

    def groupByKey () = {
        val logs = sc.parallelize(Array(("Tom", 1), ("Jack", 3), ("Jerry", 7), ("Tom", 11)))
        val result = logs.groupByKey()
    }

    def combineByKey () = {
        val logs = sc.parallelize(Array(("Tom", 1), ("Jack", 3), ("Jerry", 7), ("Tom", 11)))
        val result = logs.combineByKey( (v: Int) => (v, 1),
            (c : (Int, Int), v: Int) => (v + c._1, c._2 + 1),
            (c1: (Int, Int), c2: (Int, Int)) => (c1._1 + c2._1, c1._2 + c2._2))
    }
}
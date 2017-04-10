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
}